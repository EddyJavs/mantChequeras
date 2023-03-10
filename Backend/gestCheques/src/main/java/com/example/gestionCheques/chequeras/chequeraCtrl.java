package com.example.gestionCheques.chequeras;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionCheques.cheques.cheque;
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
	public String asignarChequera(@RequestBody chequera chequera, @PathVariable("id") Long cuentaId) {
		try {
			Optional<cuenta> c = cuentaRepo.findById(cuentaId);
			if(!c.isPresent()) {
				throw new Exception(String.format("La cuenta %d no existe", cuentaId));
			}
			chequera.setFechaAsignacion(new Timestamp(new Date().getTime()));
			chequera.setCuenta(c.get());
			
			List <cheque> listaCheques = new ArrayList<cheque>();
			
			for (int i = 0; i < 10; i++) {
				cheque ch = new cheque();
				ch.setNumeroCheque(i);
				ch.setChequera(chequera);
				listaCheques.add(ch);
			}
			chequera.setCheques(listaCheques);
			chequeraRepo.save(chequera);
			return String.format("Se asignó la chequera a la cuenta %d",chequera.getCuenta().getCuenta_id());
		}catch(Exception e) {
			return "Error al asignar cuenta: " + e;
		}
	}

}
