package com.facturador.com.models.service;

import java.util.List;

import com.facturador.com.entity.Cliente;

public interface IClienteService {

	// Base Method for Interface
	public List<Cliente> findAll();
	
	// Alternative method for Interface
	public Cliente findById(Long Id);
	
	public void save(Cliente cliente);
	
	public void delete(Cliente cliente);
	
}
