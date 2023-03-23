
package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Contador_visitas;
import com.portfolio.backend.Repository.ContadorVisitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContadorVisitasService {
	
	@Autowired ContadorVisitasRepository contadorvisitasrepository;
	
	 public int obtenerVisitas() {
        Contador_visitas contador = contadorvisitasrepository.findById(1L).orElse(new Contador_visitas());
        contador.setVisitas(contador.getVisitas() + 1);
        contadorvisitasrepository.save(contador);
        return contador.getVisitas();
    }
	
}
