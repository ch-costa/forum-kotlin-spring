create
    table tb_answers
(
    id       bigint not null auto_increment,
    message varchar2(300) not null,
    creation_date datetime not null,
    solution int(1) not null,
    topic_id bigint not null,
    author_id bigint not null,
    primary key (id),
    foreign key (author_id) references tb_users(id),
    foreign key (topic_id) references tb_topics(id)
);
