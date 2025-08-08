package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(String titulo, String mensagem, LocalDateTime data, EstadoTopico status, String autor, Curso curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
