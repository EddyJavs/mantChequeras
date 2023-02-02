package com.example.gestionCheques.cheques;


import com.example.gestionCheques.chequeras.chequera;
import com.example.gestionCheques.cuentas.cuenta;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cheque")
public class cheque {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long cheque_id;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "chequera_id")
    private chequera cuenta;
	
	@Column
	private Integer numeroCheque;
	
	@Column
	private String beneficiario;
	
	@Column
	private String monto;
	
	@Column
	private Timestamp fecha;
	
	public Long getCheque_id() {
		return cheque_id;
	}

	public void setCheque_id(Long cheque_id) {
		this.cheque_id = cheque_id;
	}

	public chequera getChequera() {
		return cuenta;
	}

	public void setChequera(chequera cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(Integer numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
}
