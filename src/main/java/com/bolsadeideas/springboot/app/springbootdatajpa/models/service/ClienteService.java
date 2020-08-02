package com.bolsadeideas.springboot.app.springbootdatajpa.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    Cliente findOne(Long id);

    void save(Cliente cliente);

    void delete(Long id);

    List<Producto> findByNombre(String term);
}