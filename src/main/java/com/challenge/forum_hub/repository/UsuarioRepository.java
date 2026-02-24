package com.challenge.forum_hub.repository;

import com.challenge.forum_hub.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByEmail(@NotBlank @Email String email);
    UserDetails findByEmail(String email);
}
