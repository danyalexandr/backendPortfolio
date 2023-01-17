package com.portfolio.backend.dto;

public class dtoExperiencia {
    
    private String puesto;
    
    private String empresa;
    
    private String fechaInicio;
    
    private String fechaFin;
    
    private String lugar;
    
    private String img;
    
    public dtoExperiencia() {
    }

    public dtoExperiencia(String puesto, String empresa, String fechaInicio, String fechaFin, String lugar, String img) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.img = img;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

     
}
