package com.example.gestionCheques.cuentas;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionCheques.clientes.ClienteRepository;
import com.example.gestionCheques.clientes.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class cuentaCtrl {
	
	@Autowired
	private CuentaRepository cuentaRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Transactional
	@RequestMapping(value = "/{clienteId}", method = RequestMethod.GET)
	public List<cuenta> obtenerPorCliente(@PathVariable("clienteId") Long clienteId){
		List<cuenta> cuentas = cuentaRepo.findByClienteId(clienteId);
		return cuentas;
	}
	
	@RequestMapping(value = "/asignar-cuenta/{id}", method = RequestMethod.POST)
	public String asignarCuenta(@RequestBody cuenta cuenta, @PathVariable("id") Long clienteId) {
		try {
			cliente c = clienteRepo.getById(clienteId);
			if(c == null) {
				throw new Exception(String.format("El cliente %d no existe", clienteId));
			}
			cuenta.setFechaApertura(new Timestamp(new Date().getTime()));
			cuenta.setCliente(c);
			cuenta cuent = cuentaRepo.save(cuenta);
			return String.format("Se asignó la cuenta al cliente %d",cuent.getCliente().getCliente_id());
		}catch(Exception e) {
			return "Error al asignar cuenta: " + e;
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long cuentaId) {
		try {
			
			cuentaRepo.deleteById(cuentaId);
			return String.format("Se eliminó el cliente %d",cuentaId);
		}catch(Exception e) {
			return "Error al eliminar el cliente: " + e;
		}
		
	}

}
