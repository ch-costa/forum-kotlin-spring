create
    table tb_topics
(
    id       bigint not null auto_increment,
    title     varchar2(60) not null,
    message varchar2(300) not null,
    creation_date datetime not null,
    status varchar2(20) not null,
    course_id bigint not null,
    author_id bigint not null,
    primary key (id),
    foreign key (course_id) references tb_courses(id),
    foreign key (author_id) references tb_users(id)
);
