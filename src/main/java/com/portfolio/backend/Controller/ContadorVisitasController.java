package com.portfolio.backend.Controller;

import com.portfolio.backend.Service.ContadorVisitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://portfoliofrontend-danyalexandr.web.app")
public class ContadorVisitasController {

	
    @Autowired
    private ContadorVisitasService contadorVisitasService;
    
     @GetMapping("/contador-visitas")
    public int obtenerVisitas() {
        return contadorVisitasService.obtenerVisitas();
    }
}
