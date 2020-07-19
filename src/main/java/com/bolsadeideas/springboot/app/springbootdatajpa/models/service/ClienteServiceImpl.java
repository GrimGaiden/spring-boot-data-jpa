package com.bolsadeideas.springboot.app.springbootdatajpa.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.dao.ClienteDao;
import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }
    
}