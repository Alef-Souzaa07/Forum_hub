ALTER TABLE topico
    ADD CONSTRAINT uk_titulo_mensagem UNIQUE (titulo, mensagem);
