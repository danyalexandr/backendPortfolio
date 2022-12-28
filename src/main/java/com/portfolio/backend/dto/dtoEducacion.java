package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    
    @NotBlank
    private String institucion;
    @NotBlank
    private String carrera;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    

    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String carrera, String fechaInicio, String fechaFin) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
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

        
}
