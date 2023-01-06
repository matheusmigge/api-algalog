-- O código abaixo só funciona se for nomeado com os dois underscores "__", dentro do padrão.
-- Então, é possível preparar um arquivo e só depois executa-lo renomeando para dentro do padrão

create table cliente(
    id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,

    primary key (id)


);