package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

public interface ClienteDao {
    
    List<Cliente> findAll();
}