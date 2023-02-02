package com.example.gestionCheques.chequeras;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionCheques.cuentas.CuentaRepository;
import com.example.gestionCheques.cuentas.cuenta;

@RestController
@RequestMapping("/chequeras")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class chequeraCtrl {
	
	@Autowired
	private chequeraRepository chequeraRepo;
	
	@Autowired
	private CuentaRepository cuentaRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<chequera> obtenerTodos(){
		return chequeraRepo.findAll();
	}
	
	@RequestMapping(value = "/asignar-chequera/{id}", method = RequestMethod.POST)
	public String asignarCuenta(@RequestBody chequera chequera, @PathVariable("id") Long cuentaId) {
		try {
			cuenta c = cuentaRepo.getById(cuentaId);
			if(c == null) {
				throw new Exception(String.format("La cuenta %d no existe", cuentaId));
			}
			chequera.setFechaAsignacion(new Timestamp(new Date().getTime()));
			chequera.setCuenta(c);
			chequera cheq = chequeraRepo.save(chequera);
			//Se crean 10 cheques para esta chequera
			for (int i = 0; i < 10; i++) {
				
			}
			return String.format("Se asignó la chequera a la cuenta %d",cheq.getCuenta().getCuenta_id());
		}catch(Exception e) {
			return "Error al asignar cuenta: " + e;
		}
	}

}
