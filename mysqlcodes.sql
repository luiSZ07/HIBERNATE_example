create database controledetarefas;
use controledetarefas;

create table estudante(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    rga INT UNIQUE NOT NULL
);

create table atividade(
	id_atividade INT AUTO_INCREMENT PRIMARY KEY,
    nome_atividade VARCHAR(100) UNIQUE NOT NULL,
    descricao_atividade VARCHAR(100) NOT NULL,
    prazo DATE,
    estudante_id INT, 
    CONSTRAINT atividade_fk FOREIGN KEY (estudante_id) REFERENCES estudante(id)
);	
