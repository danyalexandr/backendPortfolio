package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Usuario;
import com.portfolio.backend.Repository.IUsuarioRepository;
import com.portfolio.backend.Service.UsuarioService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin("https://portfoliofrontend-danyalexandr.web.app")
public class UsuarioController{
    
    @Autowired UsuarioService usuarioservice;
    @Autowired IUsuarioRepository iusuariorepository;
    
           
	 @GetMapping("/user/traer")
    public List<Usuario> getUsuario(){
        return usuarioservice.getUsuario();
    }
    
    @PostMapping("/user/crear")
    public String createPresona(@RequestBody Usuario usuario){
        usuarioservice.saveUsuario(usuario);
        return "la persona fue creada";
    }
    
    @DeleteMapping("/user/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        usuarioservice.deleteUsuario(id);
        return "la persona se borro ok";
}

    @GetMapping("/user/traer/perfil")
    public Usuario findUsuario(){
        return usuarioservice.findUsuario((int)1);
    }
    
 @PostMapping("/user/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");

    if (username != null && password != null) {
        Optional<Usuario> userOptional = iusuariorepository.findByUsername(username);
        if (userOptional.isPresent() && password.equals(userOptional.get().getPassword())) {
            String token = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("token", token);
            return ResponseEntity.ok(responseBody);
        }
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrecta");
}
}