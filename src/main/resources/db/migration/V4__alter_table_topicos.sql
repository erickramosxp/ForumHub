alter table topicos add curso varchar(50) not null;
alter table topicos add usuario_id bigint not null;
alter table topicos add
constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id);
