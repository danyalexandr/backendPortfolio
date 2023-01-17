
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Usuario findByUsername(String username);
}
