package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private EstadoTopico status;

    private String autor;

    @Embedded
    private Curso curso;

    public Topico(DadosRegistroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = dados.data();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();

    }

}
