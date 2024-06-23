create table usuarios(

    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(100) not null,
    perfil varchar(100),

    primary key(id)
);