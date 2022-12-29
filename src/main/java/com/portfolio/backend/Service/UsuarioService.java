package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Usuario;
import com.portfolio.backend.Repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{
    
    @Autowired IUsuarioRepository iusuariorepository;

    public List<Usuario> getUsuario() {
        List<Usuario> usuario = iusuariorepository.findAll();
        return usuario;
    }

    public void saveUsuario(Usuario usuario) {
        iusuariorepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
       iusuariorepository.deleteById(id);
    }

    public Usuario findUsuario(Long id) {
        Usuario usuario = iusuariorepository.findById(id).orElse(null);
        return usuario;
    }
}

    
    