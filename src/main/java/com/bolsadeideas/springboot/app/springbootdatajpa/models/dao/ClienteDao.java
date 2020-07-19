package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
    
}