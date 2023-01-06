package com.portfolio.backend.dto;

public class dtoPersona {
       
    private String nombre;
 
    private String apellido;
    
    private String puesto;

    private String acercaDe; 

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String puesto, String acercaDe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.acercaDe = acercaDe;
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
    
    
}
