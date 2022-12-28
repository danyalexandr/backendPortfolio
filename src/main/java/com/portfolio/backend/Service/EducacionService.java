package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Educacion;
import com.portfolio.backend.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    
    @Autowired 
    IEducacionRepository ieducacionrepository;
    
    public List<Educacion> List(){
    return ieducacionrepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return ieducacionrepository.findById(id);
    }
    public Optional<Educacion> getByInstitucion(String institucion){
        return ieducacionrepository.findByInstitucion(institucion);
    }
    
    public void save(Educacion edu){
        ieducacionrepository.save(edu);
    }
    
    public void delete(int id){
        ieducacionrepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ieducacionrepository.existsById(id);
    }
    
    public boolean existsByInstitucion(String institucion){
        return ieducacionrepository.existsByInstitucion(institucion);
    }
}
