package controledetarefas.modelo;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
@Table(name="estudante")
public class Estudante {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rga")
    private int rga;
    
    public Estudante(String nome, int rga) {
        this.nome = nome;
        this.rga = rga;
    }
    
    public Estudante() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;   
    }

  
    public int getRga() {
        return rga;
    }

    public void setRga(int rga) {
        this.rga = rga;
    }

    
}
