package com.example.gestionCheques.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionCheques.cuentas.CuentaRepository;



@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class clienteCtrl {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private CuentaRepository cuentaRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<cliente> obtenerTodos(){
		List<cliente> clientes = clienteRepo.findAll();
		return clientes;
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String crearNuevo(@RequestBody cliente cliente) {
		try {
			cliente c = clienteRepo.save(cliente);
			return String.format("Se creó el cliente %d - %s",c.getCliente_id() ,c.getNombre());
		}catch(Exception e) {
			return "Error al crear el cliente: " + e;
		}
		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long clienteId) {
		try {
			
			clienteRepo.deleteById(clienteId);
			return String.format("Se eliminó el cliente %d",clienteId);
		}catch(Exception e) {
			return "Error al eliminar el cliente: " + e;
		}
		
	}

}
