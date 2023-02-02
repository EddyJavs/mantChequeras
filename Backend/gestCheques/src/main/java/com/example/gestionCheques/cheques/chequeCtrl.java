package com.example.gestionCheques.cheques;

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

import com.example.gestionCheques.clientes.ClienteRepository;
import com.example.gestionCheques.clientes.cliente;
import com.example.gestionCheques.cuentas.CuentaRepository;
import com.example.gestionCheques.cuentas.cuenta;

@RestController
@RequestMapping("/cheques")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class chequeCtrl {
	
	@Autowired
	private chequeRepository chequeRepo;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public cheque registrar(@RequestBody cheque cheque){
		cheque chequeOriginal = chequeRepo.getOne(cheque.getCheque_id());
		chequeOriginal.setBeneficiario(cheque.getBeneficiario());
		chequeOriginal.setMonto(cheque.getMonto());
		chequeOriginal.setFecha(new Timestamp(new Date().getTime()));
		return chequeRepo.save(chequeOriginal);
	}
	

}
