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
@Table(name = "Educacion")
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Basic
    @Column
    private String institucion;
    @Basic
    @Column
    private String carrera;
    @Basic
    @Column
    private String fechaInicio;
    @Basic
    @Column
    private String fechaFin;
    @Basic
    @Column
    private String img;
  

    public Educacion() {
    }

    public Educacion(String institucion, String carrera, String fechaInicio, String fechaFin, String img) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.img = img;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
}

