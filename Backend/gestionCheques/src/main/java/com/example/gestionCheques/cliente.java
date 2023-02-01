package com.example.gestionCheques;

public class cliente {
	private int cliente_id;
	private String nombre;
	private String direccion;
	private String telefono;
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
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
				+ telefono + "]";
	} 
}
