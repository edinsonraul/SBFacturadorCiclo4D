package com.facturador.com.models.service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.com.entity.Cliente;
import com.facturador.com.models.dao.IClienteDao;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	private IClienteDao iclientedao;
	
	// override method interface
	@Override
	@Transactional(readOnly=true)
	// readonly evita que guarde el estado de los objetos retornados para evitar estar actualizando y ser mas eficiiente
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>)iclientedao.findAll();
	}

	// override method 
	@Override
	@Transactional(readOnly=true) 
	// readonly evita que guarde el estado de los objetos retornados para evitar estar actualizando y ser mas eficiiente
	public Cliente findById(Long Id) {
		// Si no retorna Cliente retorna null
		return (Cliente)iclientedao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		iclientedao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		iclientedao.delete(cliente);
	}	
	
}
