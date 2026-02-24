package com.challenge.forum_hub.service;

import com.challenge.forum_hub.dto.DadosAtualizacaoTopico;
import com.challenge.forum_hub.dto.DadosCadastroTopico;
import com.challenge.forum_hub.dto.DadosListagemTopico;
import com.challenge.forum_hub.entity.Topico;
import com.challenge.forum_hub.exception.ValidadorDeTopicos; // Importe sua interface
import com.challenge.forum_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    // O Spring injeta automaticamente todas as classes que implementam a interface
    @Autowired
    private List<ValidadorDeTopicos> validadores;

    @Transactional
    public DadosListagemTopico cadastrar(DadosCadastroTopico dados) {
        // 1. Executa todos os validadores (incluindo o de duplicidade)
        // Se algum falhar, ele lança a ValidacaoException e o TratadorDeErros cuida do resto
        validadores.forEach(v -> v.validar(dados));

        // 2. Se passou pelas validações, cria e salva a entidade
        var topico = new Topico(dados);
        repository.save(topico);

        // 3. Retorna o DTO de resposta (boa prática em vez de retornar a entidade pura)
        return new DadosListagemTopico(topico);
    }

    public List<DadosListagemTopico> listar() {
        return repository.findAll().stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

    @Transactional
    public DadosListagemTopico atualizar(@Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(dados.id());

        if (dados.titulo() != null) {
            topico.setTitulo(dados.titulo());
        }
        if (dados.mensagem() != null) {
            topico.setMensagem(dados.mensagem());
        }
        return new DadosListagemTopico(topico);
    }

    @Transactional
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}