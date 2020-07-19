package com.bolsadeideas.springboot.app.springbootdatajpa.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

public interface ClienteService {
    List<Cliente> findAll();

    Cliente findOne(Long id);

    void save(Cliente cliente);

    void delete(Long id);
}