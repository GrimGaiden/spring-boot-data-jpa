package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> listAll() {
        return em.createQuery("from Cliente").getResultList();
    }
    
}