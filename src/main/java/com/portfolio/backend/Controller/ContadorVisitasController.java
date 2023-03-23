package com.portfolio.backend.Controller;

import com.portfolio.backend.Service.ContadorVisitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://portfoliofrontend-danyalexandr.web.app")
public class ContadorVisitasController {

	
    @Autowired
    ContadorVisitasService contadorVisitasService;
    
    @RequestMapping(value = "/contador-visitas", method = RequestMethod.GET)
    public int obtenerVisitas() {
        return contadorVisitasService.obtenerVisitas();
    }
}
