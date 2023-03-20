package com.portfolio.backend.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Persona")
public class Persona implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Basic
    @Column
    private String nombre;
    @Basic
    @Column
    private String apellido;
    @Basic
    @Column
    private String puesto;
    @Basic
    @Column
    private String acercaDe;
    @Basic
    @Column
    private String img;

	public Persona() {
	}

	public Persona(String nombre, String apellido, String puesto, String acercaDe, String img) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.acercaDe = acercaDe;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getAcercaDe() {
		return acercaDe;
	}

	public void setAcercaDe(String acercaDe) {
		this.acercaDe = acercaDe;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}   
 } 
