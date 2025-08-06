package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DadosRegistroTopico(
        String titulo,
        String mensagem,
        LocalDateTime data,
        EstadoTopico status,
        String autor,
        Curso curso
) {

}
