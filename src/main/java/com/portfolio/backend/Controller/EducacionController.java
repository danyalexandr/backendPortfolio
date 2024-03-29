package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Educacion;
import com.portfolio.backend.Service.EducacionService;
import com.portfolio.backend.dto.dtoEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class EducacionController {
    
    @Autowired 
    EducacionService educacionservice;
    
    @GetMapping("/educacion/lista")
    public ResponseEntity<List<Educacion>> List(){
        
        List<Educacion> list = educacionservice.List();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/educacion/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionservice.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Educacion educacion = educacionservice.getOne(id).get();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @PostMapping(value = "/educacion/crear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getInstitucion())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(educacionservice.existsByInstitucion(dtoedu.getInstitucion()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoedu.getInstitucion(), dtoedu.getCarrera(),
                                            dtoedu.getFechaInicio(), dtoedu.getFechaFin(), dtoedu.getImg());
        educacionservice.save(educacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping(value = "/educacion/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        
        if(!educacionservice.existsById(id))
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        
        if(educacionservice.existsByInstitucion(dtoedu.getInstitucion()) && educacionservice.getByInstitucion(dtoedu.getInstitucion()).get().getId() != id)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getInstitucion()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionservice.getOne(id).get();
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setCarrera(dtoedu.getCarrera());
        educacion.setFechaInicio(dtoedu.getFechaInicio());
        educacion.setFechaFin(dtoedu.getFechaFin());
        
        
        educacionservice.save(educacion);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    
    @DeleteMapping(value = "/educacion/borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!educacionservice.existsById(id))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            
            educacionservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}

