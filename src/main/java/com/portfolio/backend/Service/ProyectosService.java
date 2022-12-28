package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Proyectos;
import com.portfolio.backend.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    
    @Autowired IProyectosRepository iproyectosrepository;
    
    public List<Proyectos> List(){
    return iproyectosrepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return iproyectosrepository.findById(id);
    }
    public Optional<Proyectos> getByNombre(String nombre){
        return iproyectosrepository.findByNombre(nombre);
    }
    
    public void save(Proyectos pro){
        iproyectosrepository.save(pro);
    }
    
    public void delete(int id){
        iproyectosrepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iproyectosrepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iproyectosrepository.existsByNombre(nombre);
    }
}
