package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Educacion;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);    
}
