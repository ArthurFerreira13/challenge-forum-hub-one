package com.challenge.forum_hub.exception;

import com.challenge.forum_hub.dto.DadosCadastroUsuario;
import org.springframework.stereotype.Component;


public interface ValidadorDeUsuario {
    void validar(DadosCadastroUsuario dados);
}
