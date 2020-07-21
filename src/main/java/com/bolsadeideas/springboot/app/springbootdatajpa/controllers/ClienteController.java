package com.bolsadeideas.springboot.app.springbootdatajpa.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.app.springbootdatajpa.models.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {

        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(name = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        if(id > 0) {
            Cliente cliente = clienteService.findOne(id);
            if(cliente == null) {
                flash.addFlashAttribute("error", "El cliente no existe en la BBDD!");
                return "redirect:/listar";
            }
            model.put("cliente", cliente);
            model.put("titulo", "Formulario de Cliente");
            return "form";
        }
        else {
            flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
            return "redirect:/listar";
        }
    }

    //Para pasar al formulario el objeto cliente al haber error tienen que coincider el nombre de la clase "Cliente" y el
    //nombre con el que se utiliza en la vista, si no hay que especificar el nombre utilizado en los atributos del POST con
    //@ModelAttribute("nombre que se envía a la vista")
    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {

        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        String mensajeFlash = (cliente.getId() != null)? "Cliente editado con éxito": "Cliente creado con éxito";
        clienteService.save(cliente);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listar";
    }

    @GetMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
        if(id > 0) {
            clienteService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito");
        }
        return "redirect:/listar";
    }
    
}