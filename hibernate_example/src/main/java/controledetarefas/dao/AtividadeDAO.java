package controledetarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import controledetarefas.modelo.Atividade;

public class AtividadeDAO {
    private EntityManager em;

    public AtividadeDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Atividade a){
	this.em.persist(a);
    }

    public Atividade buscarPorID(int id){
        return this.em.find(Atividade.class, id);
    }

    public void remover(Atividade a) {
        em.merge(a);
        this.em.remove(a);
    }

    public void atualizar(Atividade a) {
        this.em.merge(a);
    }

    public List<Atividade> listarTodasAtividades(){
        String jpql = "SELECT a FROM Atividade a";
        return this.em.createQuery(jpql, Atividade.class).getResultList();        
    }

    public void imprimirAtividade(List<Atividade> atividades) {
        System.out.println("+---------------------+----------------------+------------------------+");
        System.out.println("|     ID Atividade   |   Nome da Atividade   |     Descrição           |");
        System.out.println("+---------------------+----------------------+------------------------+");
    
        for (Atividade atividade : atividades) {
            System.out.printf("| %-19s| %-21s| %-24s|\n",
                atividade.getId_atividade(),
                atividade.getNome_atividade(),
                atividade.getDescricao_atividade()
            );
        }
    
        System.out.println("+---------------------+----------------------+------------------------+");
    }
    public void imprimirAtividade(Atividade atividade) {
        System.out.println("+---------------------+----------------------+------------------------+----------------------+");
        System.out.println("|     ID Atividade   |   Nome da Atividade   |     Descrição           |  Estudante (ID)      |");
        System.out.println("+---------------------+----------------------+------------------------+----------------------+");
    
        System.out.printf("| %-19s| %-21s| %-24s| %-20d|\n",
            atividade.getId_atividade(),
            atividade.getNome_atividade(),
            atividade.getDescricao_atividade(),
            atividade.getEstudante().getId()
        );
    
        System.out.println("+---------------------+----------------------+------------------------+----------------------+");
    }
    
}
