package com.portfolio.backend.dto;

public class dtoProyectos {
    
    private String nombre;
    
    private String descripcion;
    
    private String img;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String descripcion, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
