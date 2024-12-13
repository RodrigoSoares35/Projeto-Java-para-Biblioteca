
-- lOGIN E SENHA 
-- Rodrigo
-- 123

create database biblioteca_atv05_uc15;
use biblioteca_atv05_uc15;


-- CRIAÇÃO DE TABELAS
create table administrador(
id int not null auto_increment primary key,
nome varchar(45) not null,
login varchar(45),
senha varchar(45),
tipo varchar(45)
);

create table usuarios(
id int not null auto_increment primary key,
nome varchar(45), 
dataNascimento date, 
cpf varchar(45), 
telefone varchar(45), 
endereco varchar(45) 
);

create table livros(
idLivro int not null auto_increment primary key,
nomelivro varchar(45) not null,
autor varchar(45),
categoria varchar(45), 
quantidade int, 
localizacao varchar(45)

);

create table emprestimos(
idEmprestimo int not null auto_increment primary key,
idUsuario int,
nomeleitor varchar(45),
nomeLivro varchar(255), 
dataEmprestimo date,
dataEntrega date
);


-- Inserindo Dados do administrador
Insert into administrador(nome, login, senha, tipo)values("Rodrigo", "Rodrigo",md5("123"), "Adm" );
Insert into administrador(nome, login, senha, tipo)values("Jose", "Jose",md5("456"), "Comum" );

-- Inserido Usuários
insert into usuarios
(nome, dataNascimento, cpf, telefone, endereco)values
('Renato Dias','2004-05-07','593.325.902-06','(83) 99867-2023','Sitio Estreito PB'),
('Cauã Gonçalves','1961-06-16','920.247.431-10','(83) 98556-9935','Sitio Estreito PB'),
('Fernando Santos','1953-02-07','495.671.634-64','(83) 98743-2239','Sitio Estreito PB'),
('Anderson Baptista','1974-11-26','249.210.597-05','(83) 98363-3348','Sitio Estreito PB'),
('Josefa Pires','1999-10-18','761.678.756-85','(83) 98559-1691','Sitio Estreito PB'),
('Caroline Assunção','1989-07-25','614.338.247-60','(83) 98807-2486','Sitio Estreito PB'),
('Henry Enrico','1997-01-11','340.967.419-57','(83) 98721-8282','Sitio Estreito PB'),
('Sabrina Isabelly','2004-02-10','918.706.202-08','(83) 99743-1800','Sitio Estreito PB'),
('Francisca Fabiana','2000-06-03','326.426.214-21','(83) 98661-6255','Sitio Estreito PB'),
('Rebeca Caroline','2006-06-17','011.809.789-00','(83) 98155-7176','Sitio Estreito PB');

-- Inserindo Livros
insert into livros
(nomelivro, autor, categoria,quantidade, localizacao)values
(' Ilíada', 'Homero', 'Romance', 2 , 'Setor A-01'),
(' Odisseia', 'Homero', 'Romance', 3 , 'Setor A-02'),
(' Hamlete' , 'William Shakespeare','Romance', 3 , 'Setor A-02'),
(' O Engenhoso Fidalgo Dom Quixote de la Mancha', 'Miguel de Cervantes', 'Romance', 3 , 'Setor A-03'),
('A Divina Comédia', 'Dante Alighieri', 'Romance', 1 , 'Setor A-04'),
('Em Busca do Tempo Perdido', 'Marcel Proust', 'Ficçao', 1 , 'Setor A-05'),
('Ulisses', 'James Joyce', 'Romance', 4 , 'Setor A-06'),
('Guerra e Paz', 'Leon Tosltói', 'Romance Policial', 3 , 'Setor A-07'),
('Os Ensaios', 'Michel de Montaigne', 'Romance',  5 , 'Setor A-08'),
('Os Três Mosqueteiros ', 'Alexandre Dumas', 'Romance', 4 , 'Setor A-09'),
('As viagens de Gulliver', 'Jonathan Swift', 'Romance',9 , 'Setor A-10'),
('Retrato de uma Senhora', 'Henry James', 'Romance', 3 , 'Setor B-01'),
('A Vida de Galileu', 'Bertolt Brecht', 'Romance', 3 , 'Setor B-02'),
('As Três Irmãs', ' Anton Tchekhov', 'Romance', 1 , 'Setor B-03'),
('Paraíso Perdido', ' John Milton', 'Romance', 1 , 'Setor B-04'),
('O Rinoceronte', 'Eugène Ionesco', 'Infantil',  1 , 'Setor B-05'),
('Memórias de Adriano', 'Marguerite Yourcenar', 'Romance', 1 , 'Setor B-06'),
('As Aventuras de Huckleberry Finn', 'Mark Twain', 'Aventura',2 , 'Setor B-07'),
('Trópico de Câncer', 'Henry Miller', 'Romance', 1 , 'Setor B-08'),
('O Náufrago', 'Thomas Bernhard', 'Drama', 2 , 'Setor B-09'),
('As Cidades Invisíveis', ' Italo Calvino', 'Romance',  1 , 'Setor B-10');

-- Inserido Emprestimos
insert into emprestimos
(idUsuario, nomeleitor, nomeLivro, dataEmprestimo, dataEntrega)values
(1,'Renato Dias',' Hamlete', '2023-01-03','2023-03-01'),
(6,'Caroline Assunção', 'Paraíso Perdido', '2023-01-10', null),
(8,'Sabrina Isabelly', ' Ilíada', '2023-03-13', null),
(3,'Fernando Santos', 'A Divina Comédia', '2023-03-23', '2023-04-10'),
(9,'Francisca Fabiana',  'Os Três Mosqueteiros', '2023-04-01', null);

delete from administrador where id = 2;
