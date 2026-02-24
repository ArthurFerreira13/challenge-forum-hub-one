package com.challenge.forum_hub.repository;

import com.challenge.forum_hub.entity.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensagem(@NotBlank(message = "O título não pode ser vazio") String titulo, @NotBlank( message = "A mensagem não pode ser vazia") String mensagem);
}
