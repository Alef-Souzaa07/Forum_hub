package br.com.alura.Forum_hub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor      // necessário para o JPA
@AllArgsConstructor     // útil para testes, DTOs ou criação manual
public class Curso {

    private String nome;
    private String categoria;

    public Curso(@NotNull @Valid DadosDoCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
