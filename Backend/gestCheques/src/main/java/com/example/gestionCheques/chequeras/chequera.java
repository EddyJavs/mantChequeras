package com.example.gestionCheques.chequeras;


import com.example.gestionCheques.cheques.cheque;
import com.example.gestionCheques.cuentas.cuenta;
import java.sql.Timestamp;
import java.util.List;

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
@Table(name = "chequera")
public class chequera {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long chequera_id;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "cuenta_id")
    private cuenta cuenta;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cheque")
    private List<cheque> cheques;
    
    public List<cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<cheque> cheques) {
		this.cheques = cheques;
	}

	@Column
	private Timestamp fechaAsignacion;
	
	public Long getChequera_id() {
		return chequera_id;
	}

	public void setChequera_id(Long chequera_id) {
		this.chequera_id = chequera_id;
	}

	public cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Timestamp getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Timestamp fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

}
