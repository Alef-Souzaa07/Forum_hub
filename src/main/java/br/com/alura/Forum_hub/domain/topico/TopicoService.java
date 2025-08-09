package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.error.excecoes.RegistroDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicoService {

    @Autowired
    private TopicoRespository topicoRespository;

    @Transactional
    public void registrarTopico(DadosRegistroTopico dados) {
        boolean exists = topicoRespository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if (exists) {
            throw new RegistroDuplicadoException("Esse registro de título e mensagem já existe");
        }
        topicoRespository.save(new Topico(dados));
    }

    @Transactional
    public DadosDetalhamentoTopico atualizarTopico(Long id, DadosAtualizacaoTopico dados) {
        Topico topico = topicoRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico com ID " + id + " não encontrado"));

        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoTopico(topico);
    }

}


