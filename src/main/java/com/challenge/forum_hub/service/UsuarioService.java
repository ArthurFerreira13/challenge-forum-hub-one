package com.challenge.forum_hub.service;

import com.challenge.forum_hub.dto.DadosAtualizacaoUsuario;
import com.challenge.forum_hub.dto.DadosCadastroUsuario;
import com.challenge.forum_hub.dto.DadosListagemUsuario;
import com.challenge.forum_hub.entity.Usuario;
import com.challenge.forum_hub.exception.ValidacaoException;
import com.challenge.forum_hub.exception.ValidadorDeUsuario;
import com.challenge.forum_hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private List<ValidadorDeUsuario> validadores; // Sua interface de validação de usuário

    @Transactional
    public DadosListagemUsuario cadastrar(DadosCadastroUsuario dados) {
        validadores.forEach(v -> v.validar(dados));

        // Por enquanto, salvamos a senha sem criptografia (já que pausamos o JWT)
        var usuario = new Usuario(dados.nome(), dados.email(), dados.senha());
        repository.save(usuario);

        return new DadosListagemUsuario(usuario);
    }

    public List<DadosListagemUsuario> listar() {
        return repository.findAll().stream()
                .map(DadosListagemUsuario::new)
                .toList();
    }

    @Transactional
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ValidacaoException("Usuário não encontrado!");
        }
        repository.deleteById(id);
    }

    @Transactional
    public DadosListagemUsuario atualizar(Long id, DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(id);

        if (dados.nome() != null) {
            usuario.setNome(dados.nome());
        }

        if (dados.email() != null) {
            if (!dados.email().equals(usuario.getEmail()) && repository.existsByEmail(dados.email())) {
                throw new ValidacaoException("E-mail já cadastrado por outro usuário!");
            }
            usuario.setEmail(dados.email());
        }

        return new DadosListagemUsuario(usuario);
    }
}
