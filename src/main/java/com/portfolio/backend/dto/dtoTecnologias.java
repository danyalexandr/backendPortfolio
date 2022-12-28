package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;


public class dtoTecnologias {
    
     @NotBlank
    private String habilidad;
    @NotBlank
    private int porcentaje;

    public dtoTecnologias() {
    }

    public dtoTecnologias(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    
}
