package com.example.gestionCheques.clientes;

import java.util.List;

import com.example.gestionCheques.cuentas.cuenta;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class cliente {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long cliente_id;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String telefono;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
    private List<cuenta> cuentas;
	
	public List<cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "cliente [cliente_id=" + cliente_id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", cuentas=" + cuentas.toString() + "]";
	}
	
	
}
