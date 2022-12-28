package com.portfolio.backend.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona implements Serializable {

        public Persona(Long id, String nombre, String apellido, String puesto, String acercaDe, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.acercaDe = acercaDe;
        this.img = img;
        
    }

    public Persona() {
    }
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Basic
    private String nombre;
    @NotNull
    @Basic
    private String apellido;
    
    @Basic
    private String puesto;
    
    @Basic
    private String acercaDe;
    
    @Basic
    private String img;
    
    
}
