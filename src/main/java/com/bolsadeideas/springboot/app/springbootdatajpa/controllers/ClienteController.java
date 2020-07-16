package com.bolsadeideas.springboot.app.springbootdatajpa.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.dao.ClienteDao;
import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {

        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    //Para pasar al formulario el objeto cliente al haber error tienen que coincider el nombre de la clase "Cliente" y el
    //nombre con el que se utiliza en la vista, si no hay que especificar el nombre utilizado en los atributos del POST con
    //@ModelAttribute("nombre que se envía a la vista")
    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}