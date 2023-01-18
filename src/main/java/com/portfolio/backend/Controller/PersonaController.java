package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Service.PersonaService;
import com.portfolio.backend.dto.dtoPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/persona")
@CrossOrigin(origins = "https://portfoliofrontend-danyalexandr.web.app")
public class PersonaController {
    @Autowired PersonaService personaservice;
    
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> List(){
        
        List<Persona> list = personaservice.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Exception("obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(personaservice.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Exception("ya xiste"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(),
                                      dtopersona.getPuesto(), dtopersona.getAcercaDe(), dtopersona.getImg());
        personaservice.save(persona);
        return new ResponseEntity(new Exception("agregado"),HttpStatus.OK);
    }
    
    @RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!personaservice.existsById(id))
                return new ResponseEntity(new Exception("no existe"), HttpStatus.BAD_REQUEST);
            
            personaservice.delete(id);
            return new ResponseEntity(new Exception("eliminado"), HttpStatus.OK);
        }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        
        if(!personaservice.existsById(id))
         return new ResponseEntity(new Exception("no existe id"),HttpStatus.BAD_REQUEST);        
        
        if(personaservice.existsByNombre(dtopersona.getNombre()) && personaservice.getByNombre(dtopersona                                         .getNombre()).get().getId() != id)
            return new ResponseEntity(new Exception("ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Exception("obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaservice.getOne(id).get();
	persona.setNombre(dtopersona.getNombre());
	persona.setApellido(dtopersona.getApellido());
	persona.setPuesto(dtopersona.getPuesto());
	persona.setAcercaDe(dtopersona.getAcercaDe());
	persona.setImg(dtopersona.getImg());
         
        personaservice.save(persona);
        return new ResponseEntity(new Exception("actualizado"), HttpStatus.OK);
        }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaservice.existsById(id))
            return new ResponseEntity(new Exception("no existe"), HttpStatus.NOT_FOUND);
        Persona proyectos = personaservice.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
  }
