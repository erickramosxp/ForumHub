create table topicos(

    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensagem text not null,
    data datetime not null,
    status varchar(100),

    primary key(id)
);