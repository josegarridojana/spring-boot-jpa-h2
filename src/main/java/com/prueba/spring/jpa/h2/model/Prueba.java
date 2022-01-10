package com.prueba.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tutorials")
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "vigente")
	private boolean vigente;
	
	@CreationTimestamp
	@Column(name="fecha_creacion", nullable=false, updatable=false)
	private Date fechaCreacion;
	
	@UpdateTimestamp
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;


	public Prueba() {

	}

	public Prueba(String nombre, String descripcion, boolean vigente) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.vigente = vigente;
		this.fechaCreacion = new Date();
		this.fechaActualizacion = new Date();
	}
	

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", vigente=" + vigente
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	

}
