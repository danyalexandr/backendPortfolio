
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Contador_visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorVisitasRepository extends JpaRepository<Contador_visitas, Long> {

}