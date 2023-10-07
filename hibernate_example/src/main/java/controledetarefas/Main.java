package controledetarefas;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import controledetarefas.dao.AtividadeDAO;
import controledetarefas.dao.EstudanteDAO;
import controledetarefas.modelo.Atividade;
import controledetarefas.modelo.Estudante;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ufmt");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        AtividadeDAO aDAO = new AtividadeDAO(entityManager);         
        EstudanteDAO eDAO = new EstudanteDAO(entityManager);

        //inserir construtores de objetos genéricos de atividade e estudante e cadastrá-los na janela de transação

        entityManager.getTransaction().begin();
        //operações no banco de dados
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}