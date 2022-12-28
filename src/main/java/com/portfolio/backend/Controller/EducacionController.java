package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Educacion;
import com.portfolio.backend.Service.EducacionService;
import com.portfolio.backend.dto.dtoEducacion;
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
@RequestMapping("educa")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired 
    EducacionService educacionservice;
    
    @GetMapping("/listaedu")
    public ResponseEntity<List<Educacion>> List(){
        
        List<Educacion> list = educacionservice.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detailedu/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionservice.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionservice.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/crearedu")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getInstitucion())){
            return new ResponseEntity(new Mensaje("obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(educacionservice.existsByInstitucion(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("ya xiste"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoedu.getInstitucion(), dtoedu.getCarrera(),
                                            dtoedu.getFechaInicio(), dtoedu.getFechaFin());
        educacionservice.save(educacion);
        return new ResponseEntity(new Mensaje("agregado"),HttpStatus.OK);
    }
    
    @PutMapping("/updateedu/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        
        if(!educacionservice.existsById(id))
         return new ResponseEntity(new Mensaje("no existe id"),HttpStatus.BAD_REQUEST);        
        
        if(educacionservice.existsByInstitucion(dtoedu.getInstitucion()) && educacionservice.getByInstitucion(dtoedu.getInstitucion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionservice.getOne(id).get();
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setCarrera(dtoedu.getCarrera());
        educacion.setFechaInicio(dtoedu.getFechaInicio());
        educacion.setFechaFin(dtoedu.getFechaFin());
        
        
        educacionservice.save(educacion);
        return new ResponseEntity(new Mensaje("actualizado"), HttpStatus.OK);
        }
    
    @DeleteMapping("/borraredu/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!educacionservice.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
            
            educacionservice.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }
    
    private static class Mensaje {

        public Mensaje(String obligatorio) {
        }
    }
}
