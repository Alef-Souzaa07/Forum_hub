package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;
import br.com.alura.Forum_hub.domain.curso.DadosDoCurso;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String mensagem;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
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
        this.curso = new Curso(dados.curso());

    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) this.titulo = dados.titulo();
        if (dados.mensagem() != null) this.mensagem = dados.mensagem();
        if (dados.status() != null) this.status = dados.status();
        if (dados.autor() != null) this.autor = dados.autor();
        if (dados.curso() != null) this.curso = dados.curso();
        // Data não é alterada
    }

}
