package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired 
    IExperienciaRepository iexperienciarepository;
    
    public List<Experiencia> List(){
    return iexperienciarepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iexperienciarepository.findById(id);
    }
    public Optional<Experiencia> getByNombreE(String nombreE){
        return iexperienciarepository.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp){
        iexperienciarepository.save(exp);
    }
    
    public void delete(int id){
        iexperienciarepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iexperienciarepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return iexperienciarepository.existsByNombreE(nombreE);
    }
    
}
