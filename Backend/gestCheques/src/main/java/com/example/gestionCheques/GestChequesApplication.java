package com.example.gestionCheques;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestChequesApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(GestChequesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<cliente> clientes = clienteRepo.findAll();	
		clientes.forEach(System.out :: println);
	}

}
