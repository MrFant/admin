drop table if exists `user`;
create table `user`(
    id identity,
    username varchar(30) not null,
    password varchar(50) not null,
    name varchar(13),
    email varchar(30),
    phone varchar(30)
);

drop table if exists `authority`;
create table `authority` (
  id identity,
  name varchar(30) NOT NULL
);

drop table if exists `user_authority`;
create table `user_authority` (
  user_id bigint(20) NOT NULL ,
  authority_id bigint(20) NOT NULL ,
  FOREIGN KEY (user_id) references `user`(id),
  FOREIGN KEY (authority_id) references `authority`(id)
)