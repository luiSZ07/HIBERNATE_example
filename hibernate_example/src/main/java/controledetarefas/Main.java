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

        //substituir por construtores de objetos genéricos de atividade e estudante e cadastrá-los na janela de transação
        /* 
        Estudante estudante1 = eDAO.buscarPorID(1);
        Estudante estudante2 = eDAO.buscarPorID(2);
        Atividade atividade1 = aDAO.buscarPorID(1);
        Atividade atividade2 = aDAO.buscarPorID(2);
        Atividade atividade3 = new Atividade("Atividade 3", "Descrição da Atividade 3", LocalDate.of(2023, 11, 02), estudante1);
        */
        List<Atividade> listAtv;
        List<Atividade> listAtvAux;
        Atividade atvAux;

        entityManager.getTransaction().begin();
            aDAO.cadastrar(atividade3);
            listAtvAux = eDAO.listarAtividades(estudante1);
            atvAux = aDAO.buscarPorID(2);
            listAtv = aDAO.listarTodasAtividades();
        
        entityManager.getTransaction().commit();

        aDAO.imprimirAtividade(listAtvAux);
        aDAO.imprimirAtividade(atvAux);
        aDAO.imprimirAtividade(listAtv);

        entityManager.close();
    }
}