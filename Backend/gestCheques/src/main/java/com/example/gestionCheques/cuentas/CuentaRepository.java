package com.example.gestionCheques.cuentas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends JpaRepository<cuenta, Long> {
	
	@Query("SELECT u FROM cuenta u WHERE u.clienteId = :clienteId")
    List<cuenta> findByClienteId(@Param("clienteId") Long clienteId);
}
