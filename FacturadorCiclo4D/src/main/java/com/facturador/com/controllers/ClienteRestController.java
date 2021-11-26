package com.facturador.com.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.com.entity.Cliente;
import com.facturador.com.models.service.ClienteServiceImp;
import com.facturador.com.models.service.IClienteService;

//Indicador Controlador
@RestController
// Dirección Acceso(Da acceso a frontend Angular)
@CrossOrigin(origins= {"http://localhost:4200"})
// Nombre Resuelve el Controlador
@RequestMapping("/api")
public class ClienteRestController {

	// Inyección de Dependencias para Acceder Metodo de la interfaz findAll()
	@Autowired
	private ClienteServiceImp clienteservice;
	
	// Retorna Listado
	// Acceso metodo desde la URL	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteservice.findAll();
	}

	// Retorna un solo cliente
	// pasando el parametro de id de tabla con Pathvariable para que se pueda enviar en la URI
	@GetMapping("/clientes/{Id}")
	public Cliente show(@PathVariable Long Id) {
		return clienteservice.findById(Id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	// Parametro enviado en el Body de la petición
	public Cliente create(@RequestBody Cliente cliente) {
		//cliente.setCreateat(new Date());
		clienteservice.save(cliente);
		return cliente;
	}
	
	@PutMapping("/clientes/{Id}")
	@ResponseStatus(HttpStatus.CREATED)
	// Parametro enviado en el Body de la petición
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long Id){
		Cliente currentcliente=clienteservice.findById(Id);		
		currentcliente.setNombre(cliente.getNombre());
		currentcliente.setApellido(cliente.getApellido());
		currentcliente.setDireccion(cliente.getDireccion());
		currentcliente.setEmail(cliente.getEmail());
		clienteservice.save(currentcliente);
		
		return currentcliente;
	}
	
	
}
