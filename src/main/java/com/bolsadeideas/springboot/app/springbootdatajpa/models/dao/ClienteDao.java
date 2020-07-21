package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteDao extends PagingAndSortingRepository<Cliente, Long>{
    
    
}