create table teacher
(
  id   int(10)                  not null,
  name varchar(30) default null null,
  constraint teacher_pk
    primary key (id)
)
  comment '老师'
  engine = INNODB
  default char set = utf8;


create table student
(
  id   int(10)                  not null,
  name varchar(30) default null null,
  tid  int(10)     default null null,
  constraint student_pk
    primary key (id),
  constraint student_teacher_id_fk
    foreign key (tid) references teacher (id)
)
  comment '学生'
  engine = innodb
  default character set = utf8


insert into teacher(id, name)
