package controledetarefas.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="atividade")
public class Atividade {
    @Id
    @Column(name = "id_atividade")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_atividade;

    @Column(name = "nome_atividade")
    private String nome_atividade;

    @Column(name = "descricao_atividade")
    private String descricao_atividade;

    @Column(name = "prazo")
    private LocalDate prazo;

    @ManyToOne  
    private Estudante estudante;
    
    public Atividade(String nome_atividade, String descricao_atividade, LocalDate prazo, Estudante estudante) {
        this.nome_atividade = nome_atividade;
        this.descricao_atividade = descricao_atividade;
        this.prazo = prazo;
        this.estudante = estudante;
    }

    public Atividade() {}

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }


    public String getNome_atividade() {
        return nome_atividade;
    }

    public void setNome_atividade(String nome_atividade) {
        this.nome_atividade = nome_atividade;
    }

  
    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
    
    
    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public String getDescricao_atividade() {
        return descricao_atividade;
    }

    public void setDescricao_atividade(String descricao_atividade) {
        this.descricao_atividade = descricao_atividade;
    }

}
