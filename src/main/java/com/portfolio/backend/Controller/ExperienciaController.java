package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Service.ExperienciaService;
import com.portfolio.backend.dto.dtoExperiencia;
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
public class ExperienciaController {
    
    @Autowired 
    ExperienciaService experienciaService;
    
    @GetMapping("/exp/lista")
    public ResponseEntity<List<Experiencia>> List(){
        
        List<Experiencia> list = experienciaService.List();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/exp/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/exp/crear")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getPuesto())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByPuesto(dtoexp.getPuesto()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getPuesto(), dtoexp.getEmpresa(),
                                              dtoexp.getFechaInicio(), dtoexp.getFechaFin(), dtoexp.getLugar(), 
                                                    dtoexp.getImg());
        experienciaService.save(experiencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/exp/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        
        if(!experienciaService.existsById(id))
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        
        if(experienciaService.existsByPuesto(dtoexp.getPuesto()) && experienciaService.getByPuesto(dtoexp.getPuesto()).get().getId() != id)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getPuesto()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setFechaInicio(dtoexp.getFechaInicio());
        experiencia.setFechaFin(dtoexp.getFechaFin());
        experiencia.setLugar(dtoexp.getLugar());
        
        experienciaService.save(experiencia);
        return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/exp/borrar/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            
           if(!experienciaService.existsById(id))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            
            experienciaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    
 
