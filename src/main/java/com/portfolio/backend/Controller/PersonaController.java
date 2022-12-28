package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaservice;
    
    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return ipersonaservice.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPresona(@RequestBody Persona persona){
        ipersonaservice.savePersona(persona);
        return "la persona fue creada";
    }
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaservice.deletePersona(id);
        return "la persona se borro ok";
    }
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("puesto") String nuevoPuesto,
                               @RequestParam("acercaDe") String nuevoAcercDe,
                               @RequestParam("img") String nuevoImg){
     
        Persona persona = ipersonaservice.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        ipersonaservice.savePersona(persona);
        return persona;
    }
    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return ipersonaservice.findPersona((long)1);
    }
}
