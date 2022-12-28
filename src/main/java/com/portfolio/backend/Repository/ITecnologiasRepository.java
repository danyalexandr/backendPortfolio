package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Tecnologias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiasRepository extends JpaRepository<Tecnologias, Integer>{
    public Optional<Tecnologias> findByHabilidad(String habilidad);
    public boolean existsByHabilidad(String habilidad);
}
