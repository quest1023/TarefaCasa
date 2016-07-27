create database if not exists db_login;

use db_login;

create table if not exists tb_login(
    log_id int not null auto_increment primary key,
    log_login varchar(20) not null unique key,
    log_senha varchar(20) not null,
    log_nome varchar(50) not null
);

insert into tb_login (log_login, log_senha, log_nome) values ('admin', 'senac', 'Administrador do Sistema');
