create
    table tb_users
(
    id       bigint not null auto_increment,
    name     varchar2(100) not null,
    email varchar2(60) not null,
    primary key (id)
);

insert into tb_users(id, name, email) values(1, 'Ana da Silva', 'ana@email.com');