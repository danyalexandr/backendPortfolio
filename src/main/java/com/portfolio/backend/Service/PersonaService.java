package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class PersonaService {

    @Autowired IPersonaRepository ipersonarepository;
    
   
    public List<Persona> List(){
    return ipersonarepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return ipersonarepository.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre){
        return ipersonarepository.findByNombre(nombre);
    }
    
    public void save(Persona pro){
        ipersonarepository.save(pro);
    }
    
    public void delete(int id){
        ipersonarepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersonarepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersonarepository.existsByNombre(nombre);
    }
    
}
