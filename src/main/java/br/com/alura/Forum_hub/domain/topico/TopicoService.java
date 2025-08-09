package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.error.excecoes.RegistroDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRespository repository;

    // Método privado para validar existência e retornar a entidade
    private Topico buscarTopicoOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));
    }

    // GET
    public List<Topico> listarTodos() {
        return repository.findAll();
    }

    public DadosDetalhamentoTopico DetalharTopico(Long id) {
        Topico topico = buscarTopicoOuFalhar(id);
        return new DadosDetalhamentoTopico(topico);
    }


    // POST
    @Transactional
    public Topico criarTopico(DadosRegistroTopico dados) {
        Topico topico = new Topico(dados);
        return repository.save(topico);
    }

    // PUT - atualização
    @Transactional
    public Topico atualizarTopico(Long id, DadosAtualizacaoTopico dados) {
        Topico topico = buscarTopicoOuFalhar(id);
        topico.atualizarInformacoes(dados);
        return topico;
    }

    // DELETE
    @Transactional
    public void deletarTopico(Long id) {
        Topico topico = buscarTopicoOuFalhar(id);
        repository.delete(topico);
    }
}



