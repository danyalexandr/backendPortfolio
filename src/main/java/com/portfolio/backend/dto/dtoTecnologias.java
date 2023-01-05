package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;


public class dtoTecnologias {
    
     @NotBlank
    private String habilidad;
    @NotBlank
    private String porcentaje;

    public dtoTecnologias() {
    }

    public dtoTecnologias(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = this.porcentaje;
    }

    
}
