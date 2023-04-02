package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Proyectos;
import com.portfolio.backend.Service.ProyectosService;
import com.portfolio.backend.dto.dtoProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://portfoliofrontend-danyalexandr.web.app")
public class ProyectosController {
    
    @Autowired ProyectosService proyectosservice;
    
    @GetMapping("/proyecto/lista")
    public ResponseEntity<List<Proyectos>> List(){
        
        List<Proyectos> list = proyectosservice.List();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/proyecto/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosservice.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosservice.getOne(id).get();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    
    @PostMapping("/proyecto/crear")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro){
        if(StringUtils.isBlank(dtopro.getNombre())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(proyectosservice.existsByNombre(dtopro.getNombre()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtopro.getNombre(), dtopro.getDescripcion(), dtopro.getImg());
        proyectosservice.save(proyectos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/proyecto/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro){
        
        if(!proyectosservice.existsById(id))
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        
        if(proyectosservice.existsByNombre(dtopro.getNombre()) && proyectosservice.getByNombre(dtopro.getNombre()).get().getId() != id)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = proyectosservice.getOne(id).get();
        proyectos.setNombre(dtopro.getNombre());
        proyectos.setDescripcion(dtopro.getDescripcion());      
        
        proyectosservice.save(proyectos);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    
    @DeleteMapping("/proyecto/borrar/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!proyectosservice.existsById(id))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            
            proyectosservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
}
