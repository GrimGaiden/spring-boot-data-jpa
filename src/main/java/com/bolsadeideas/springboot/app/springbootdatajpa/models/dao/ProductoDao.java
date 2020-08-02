package com.bolsadeideas.springboot.app.springbootdatajpa.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
    
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByNombre(String term);

    List<Producto> findByNombreLikeIgnoreCase(String term);
}