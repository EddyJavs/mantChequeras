package com.example.gestionCheques.cuentas;



import java.sql.Timestamp;
import java.util.List;

import com.example.gestionCheques.chequeras.chequera;
import com.example.gestionCheques.clientes.cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class cuenta {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long cuenta_id;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private cliente cliente;
	
	@Column
	private Timestamp fechaApertura;
	
	@Column
	private Integer tipoCuenta_id;
	
	@Column
	private Double monto;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "chequera")
    private List<chequera> chequeras;

	public Integer getTipoCuenta_id() {
		return tipoCuenta_id;
	}

	public void setTipoCuenta_id(Integer tipoCuenta_id) {
		this.tipoCuenta_id = tipoCuenta_id;
	}

	public List<chequera> getChequeras() {
		return chequeras;
	}

	public void setChequeras(List<chequera> chequeras) {
		this.chequeras = chequeras;
	}

	public Long getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(Long cuenta_id) {
		this.cuenta_id = cuenta_id;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public Timestamp getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Timestamp fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Integer getTipoCuenta() {
		return tipoCuenta_id;
	}

	public void setTipoCuenta(Integer tipoCuenta) {
		this.tipoCuenta_id = tipoCuenta;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
