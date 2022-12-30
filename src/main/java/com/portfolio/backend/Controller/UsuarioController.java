package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Usuario;
import com.portfolio.backend.Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("**")
public class UsuarioController{
    
    @Autowired UsuarioService usuarioservice;
    
           
	 @GetMapping("/traer")
    public List<Usuario> getUsuario(){
        return usuarioservice.getUsuario();
    }
    
    @PostMapping("/crear")
    public String createPresona(@RequestBody Usuario usuario){
        usuarioservice.saveUsuario(usuario);
        return "la persona fue creada";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        usuarioservice.deleteUsuario(id);
        return "la persona se borro ok";
}

    @GetMapping("/traer/perfil")
    public Usuario findUsuario(){
        return usuarioservice.findUsuario((long)1);
    }
}