package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Service.PersonaService;
import com.portfolio.backend.dto.dtoPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://portfoliofrontend-danyalexandr.web.app")
public class PersonaController {
    @Autowired PersonaService personaservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> List(){
        
        List<Persona> list = personaservice.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(personaservice.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("ya xiste"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(),
                                      dtopersona.getPuesto(), dtopersona.getAcercaDe());
        personaservice.save(persona);
        return new ResponseEntity(new Mensaje("agregado"),HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!personaservice.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
            
            personaservice.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        
        if(!personaservice.existsById(id))
         return new ResponseEntity(new Mensaje("no existe id"),HttpStatus.BAD_REQUEST);        
        
        if(personaservice.existsByNombre(dtopersona.getNombre()) && personaservice.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaservice.getOne(id).get();
        persona.setAcercaDe(dtopersona.getAcercaDe());
         
        personaservice.save(persona);
        return new ResponseEntity(new Mensaje("actualizado"), HttpStatus.OK);
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona proyectos = personaservice.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    /*
    @GetMapping("/traer/{id}")
    public Persona findPersona(){
        return ipersonaservice.findPersona((long)1);
    }*/
    
    private static class Mensaje {

        public Mensaje(String agregado) {
        }
    }
}
