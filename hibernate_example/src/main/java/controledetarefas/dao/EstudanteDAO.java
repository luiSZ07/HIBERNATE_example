package controledetarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import controledetarefas.modelo.Atividade;
import controledetarefas.modelo.Estudante;

public class EstudanteDAO{
    private EntityManager em;

    public EstudanteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Estudante e){
	this.em.persist(e);
    }
    public List<Atividade> listarAtividades(Estudante e) {
        String jpql = "SELECT a FROM Atividade a WHERE a.estudante = :estudante";
        return this.em.createQuery(jpql, Atividade.class)
                .setParameter("estudante", e)
                .getResultList();
    }                                                                                                                                                                               

    public List<Estudante> listarTodosEstudantes(){
        String jpql = "SELECT e FROM Estudante e";
        return this.em.createQuery(jpql, Estudante.class).getResultList();        
    }

    public void imprimirEstudante(List<Estudante> estudantes) {
        System.out.println("+--------+----------------------+---------+");
        System.out.println("|   ID   |         Nome         |   RGA   |");
        System.out.println("+--------+----------------------+---------+");
    
        for (Estudante estudante : estudantes) {
            System.out.printf("| %-6d | %-20s | %-7d |\n",
                estudante.getId(),
                estudante.getNome(),
                estudante.getRga()
            );
        }
    
        System.out.println("+--------+----------------------+---------+");
    }    

    public void imprimirEstudante(Estudante estudante) {
        System.out.println("+--------+----------------------+---------+");
        System.out.println("|   ID   |         Nome         |   RGA   |");
        System.out.println("+--------+----------------------+---------+");
            System.out.printf("| %-6d | %-20s | %-7d |\n",
                estudante.getId(),
                estudante.getNome(),
                estudante.getRga()
            );

        System.out.println("+--------+----------------------+---------+");
    }       

    public Estudante buscarPorID(int id){
        return this.em.find(Estudante.class, id);
    }

    public void remover(Estudante e) {
        em.merge(e);
        this.em.remove(e);
    }   

}