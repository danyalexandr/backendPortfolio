package com.portfolio.backend.dto;

public class dtoEducacion {
    
    
    private String institucion;
    
    private String carrera;
    
    private String fechaInicio;
    
    private String fechaFin;
    
    private String img;
    

    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String carrera, String fechaInicio, String fechaFin, String img) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.img = img;
        
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
