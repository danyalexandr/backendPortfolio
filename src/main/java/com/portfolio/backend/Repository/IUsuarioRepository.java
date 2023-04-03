
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;




public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByUsername(String username);
    
}
