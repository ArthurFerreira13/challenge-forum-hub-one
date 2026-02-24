package com.challenge.forum_hub.service;

import com.challenge.forum_hub.dto.DadosAtualizacaoTopico;
import com.challenge.forum_hub.dto.DadosCadastroTopico;
import com.challenge.forum_hub.dto.DadosListagemTopico;
import com.challenge.forum_hub.entity.Topico;
import com.challenge.forum_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    public Topico cadastrar(DadosCadastroTopico dados) {
        try {
            // Aqui você pode adicionar validações extras no futuro
            // Ex: verificar se já existe um tópico com o mesmo título
            var topico = new Topico(dados);
            return repository.save(topico);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o tópico: " + e.getMessage());
        }
    }
    public List<DadosListagemTopico> listar() {
        return repository.findAll().stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

    public DadosListagemTopico atualizar(@Valid DadosAtualizacaoTopico dados) {
        var topico = repository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado com ID: " + dados.id()));
        return new DadosListagemTopico(topico);
    }

    public void excluir(Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado com ID: " + id));
        repository.delete(topico);
    }
}
