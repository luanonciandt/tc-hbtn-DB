package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materiais")
public class MaterialCurso implements Serializable {

    public static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToOne(mappedBy = "materialCurso")
    private Curso curso;

    public MaterialCurso() {}

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
