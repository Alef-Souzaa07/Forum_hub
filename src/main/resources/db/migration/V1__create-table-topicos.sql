create table topicos(
    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensagem TEXT not null,
    data DATETIME not null ,
    status varchar(100) not null ,
    autor varchar(100),
    nome varchar(100),
    categoria varchar(255)

    primary key (id)
);