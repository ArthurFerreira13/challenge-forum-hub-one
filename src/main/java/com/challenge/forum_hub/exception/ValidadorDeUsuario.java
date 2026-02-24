package com.challenge.forum_hub.exception;

import com.challenge.forum_hub.dto.DadosCadastroUsuario;


public interface ValidadorDeUsuario {
    void validar(DadosCadastroUsuario dados);
}
