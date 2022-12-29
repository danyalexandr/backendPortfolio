package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Tecnologias;
import com.portfolio.backend.Service.TecnologiasService;
import com.portfolio.backend.dto.dtoTecnologias;
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
@RequestMapping("tecno")
@CrossOrigin(origins = "http://localhost:4200")
public class TecnologiasController {
    
    @Autowired TecnologiasService tecnologiasservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Tecnologias>> List(){
        
        List<Tecnologias> list = tecnologiasservice.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Tecnologias> getById(@PathVariable("id") int id){
        if(!tecnologiasservice.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Tecnologias tecnologias = tecnologiasservice.getOne(id).get();
        return new ResponseEntity(tecnologias, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoTecnologias dtotecno){
        if(StringUtils.isBlank(dtotecno.getHabilidad())){
            return new ResponseEntity(new Mensaje("obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(tecnologiasservice.existsByHabilidad(dtotecno.getHabilidad()))
            return new ResponseEntity(new Mensaje("ya xiste"), HttpStatus.BAD_REQUEST);
        
        Tecnologias tecnologias = new Tecnologias(dtotecno.getHabilidad(), dtotecno.getPorcentaje());
        tecnologiasservice.save(tecnologias);
        return new ResponseEntity(new Mensaje("agregado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTecnologias dtotecno){
        
        if(!tecnologiasservice.existsById(id))
         return new ResponseEntity(new Mensaje("no existe id"),HttpStatus.BAD_REQUEST);        
        
        if(tecnologiasservice.existsByHabilidad(dtotecno.getHabilidad()) && tecnologiasservice.getByHabilidad(dtotecno.getHabilidad()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtotecno.getHabilidad()))
            return new ResponseEntity(new Mensaje("obligatorio"), HttpStatus.BAD_REQUEST);
        
        Tecnologias tecnologias = tecnologiasservice.getOne(id).get();
        tecnologias.setHabilidad(dtotecno.getHabilidad());
        tecnologias.setPorcentaje(dtotecno.getPorcentaje());      
        
        tecnologiasservice.save(tecnologias);
        return new ResponseEntity(new Mensaje("actualizado"), HttpStatus.OK);
        }
    
    @DeleteMapping("/borrar/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!tecnologiasservice.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
            
            tecnologiasservice.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }

    private static class Mensaje {

        public Mensaje(String agregado) {
        }
    }
}
