package br.com.alura.Forum_hub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRespository repository;

    @Transactional
    public void registrarTopico(DadosRegistroTopico dados) {
        boolean exists = repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if (exists) {
            throw new IllegalArgumentException("Já existe um tópico com o mesmo título e mensagem.");
        }
        repository.save(new Topico(dados));
    }
}

