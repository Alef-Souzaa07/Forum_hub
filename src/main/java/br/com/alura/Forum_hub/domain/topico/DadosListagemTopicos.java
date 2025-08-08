package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;
import br.com.alura.Forum_hub.domain.curso.DadosDoCurso;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long id, String titulo, String mensagem, LocalDateTime data, EstadoTopico status, String autor, Curso curso) {
    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
