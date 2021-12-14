package com.tew.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "piso")
public class Piso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idAgente;
	private double precio;
	private String direccion;
	private int estado;
	private String ciudad;
	private int ano;
	private String foto;
	
	
	@XmlElement
	public int getAno() {
		return ano;
	}
	@XmlElement
	public String getDireccion() {
		return direccion;
	}
	@XmlElement
	public Long getId() {
		return id;
	}
	@XmlElement
	public Long getIdAgente() {
		return idAgente;
	}
	@XmlElement
	public double getPrecio() {
		return precio;
	}
	@XmlElement
	public int getEstado() {
		return estado;
	}
	@XmlElement
	public String getCiudad() {
		return ciudad;
	}
	@XmlElement
	public String getFoto() {
		return foto;
	}
	
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setIdAgente(Long idAgente) {
		this.idAgente = idAgente;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}