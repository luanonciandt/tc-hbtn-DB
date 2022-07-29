package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDD;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Telefone() {}

    public Long getId() {
        return id;
    }

    public String getDDD() {
        return DDD;
    }

    public String getNumero() {
        return numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
