package br.com.alura.Forum_hub.error.excecoes;

public class RegistroDuplicadoException extends RuntimeException {
    public RegistroDuplicadoException(String message) {
        super(message);
    }
}

