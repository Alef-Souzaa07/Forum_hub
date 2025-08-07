package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.error.excecoes.RegistroDuplicadoException;
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
            throw new RegistroDuplicadoException("Esse registro de título e mensagem já existe");
        }
        repository.save(new Topico(dados));
    }
}


