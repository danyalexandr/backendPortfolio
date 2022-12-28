package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Tecnologias;
import com.portfolio.backend.Repository.ITecnologiasRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TecnologiasService {
    
    @Autowired ITecnologiasRepository itecnologiasrepository;
    
    public List<Tecnologias> List(){
    return itecnologiasrepository.findAll();
    }
    
    public Optional<Tecnologias> getOne(int id){
        return itecnologiasrepository.findById(id);
    }
    public Optional<Tecnologias> getByHabilidad(String habilidad){
        return itecnologiasrepository.findByHabilidad(habilidad);
    }
    
    public void save(Tecnologias tecno){
        itecnologiasrepository.save(tecno);
    }
    
    public void delete(int id){
        itecnologiasrepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return itecnologiasrepository.existsById(id);
    }
    
    public boolean existsByHabilidad(String habilidad){
        return itecnologiasrepository.existsByHabilidad(habilidad);
    }
}
