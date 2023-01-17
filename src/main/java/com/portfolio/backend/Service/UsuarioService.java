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
        return iusuariorepository.findAll();
    }

    public void saveUsuario(Usuario usuario) {
        iusuariorepository.save(usuario);
    }

    public void deleteUsuario(int id) {
       iusuariorepository.deleteById(id);
    }

    public Usuario findUsuario(int id) {
        Usuario usuario;
	    usuario = iusuariorepository.findById(id).orElse(null);
        return usuario;
    }
}

    
    