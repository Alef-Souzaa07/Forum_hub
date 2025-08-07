package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;
import br.com.alura.Forum_hub.domain.curso.DadosDoCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        LocalDateTime data,

        @NotNull
        EstadoTopico status,


        String autor,

        @NotNull
        @Valid
        DadosDoCurso curso
) {

}
