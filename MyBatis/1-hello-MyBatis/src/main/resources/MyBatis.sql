create schema User;


create table User
(
  id   int                      not null,
  name varchar(30) default null null,
  pwd  varchar(30) default null null,
  constraint User_pk
    primary key (id)
) ENGINE = INNODB
    DEFAULT CHARACTER SET = utf8;


insert into User(id, name, pwd)
values (1, '张三', 123456),
       (2, '李四', 123456),
       (3, '王五', 123456),
       (4, '赵六', 123456)
