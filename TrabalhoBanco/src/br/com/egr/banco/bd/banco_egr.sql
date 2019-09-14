create database banco_egr;
use banco_egr;

create table cliente(
idcliente int not null auto_increment,
nome varchar(60) not null,
endereco varchar(60) not null,
primary key(idcliente)
);

create table pessoaFisica(
cpf varchar(20) not null,
idcliente int not null,
nomeMae varchar(100) not null,
nomePai varchar(100) not null,
primary key(cpf),
foreign key (idcliente) references cliente (idcliente)
);

create table pessoaJuridica(
cnpj varchar(40) not null,
idcliente int not null,
nomeFantasia varchar(150),
primary key(cnpj),
foreign key (idcliente) references cliente (idcliente)
);


create table conta(
numero bigint not null,
saldo double not null,
situacao boolean not null,
tipo int not null,
primary key(numero)
);

create table seguro(
numero int not null,
valor double not null,
situacao boolean not null,
primary key(numero)
);


create table cliente_conta(
idcliente_conta int not null auto_increment,
idcliente int not null,
numero bigint not null,
primary key(idcliente_conta),
foreign key(idcliente) references cliente (idcliente),
foreign key(numero) references conta (numero)
);

create table cliente_seguro(
idcliente_seguro int not null auto_increment,
idcliente int not null,
numero bigint not null,
primary key(idcliente_seguro),
foreign key(idcliente) references cliente (idcliente),
foreign key(numero) references conta (numero)
);
