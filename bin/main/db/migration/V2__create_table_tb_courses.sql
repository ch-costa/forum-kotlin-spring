create
    table tb_courses
(
    id       bigint not null auto_increment,
    name     varchar2(60) not null,
    category varchar2(60) not null,
    primary key (id)
);

insert into tb_courses(id, name, category) values(1, 'Kotlin', 'PROGRAMACAO');