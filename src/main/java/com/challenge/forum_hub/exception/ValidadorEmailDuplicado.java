package com.challenge.forum_hub.exception;

import com.challenge.forum_hub.dto.DadosCadastroUsuario;
import com.challenge.forum_hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorEmailDuplicado implements ValidadorDeUsuario{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(DadosCadastroUsuario dados) {
        // Verifica se o email já existe no banco de dados conforme o diagrama
        var emailExiste = repository.existsByEmail(dados.email());

        if (emailExiste) {
            // Reutiliza a sua classe personalizada de exceção
            throw new ValidacaoException("Não é possível cadastrar: este e-mail já está em uso!");
        }
    }
}
