package cl.ipss.api_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.api_demo.model.*;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
