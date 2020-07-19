package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void save(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() >0) {
            em.merge(cliente);
        }
        else {
            em.persist(cliente);
        }
    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
    
}