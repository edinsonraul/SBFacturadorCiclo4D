package com.facturador.com.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.facturador.com.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

}
