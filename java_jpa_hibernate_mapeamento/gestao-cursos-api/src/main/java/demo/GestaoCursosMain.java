package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestaoCursosMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Telefone t1 = new Telefone();
        t1.setNumero("4002-8922");
        t1.setDDD("81");

        try {
            em.getTransaction().begin();
            em.persist(t1);
            em.getTransaction().commit();
            System.out.println("Telefone adicionado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Endereco e1 = new Endereco();
        e1.setBairro("Amparo");
        e1.setCidade("Olinda");
        e1.setNumero("62");
        e1.setEstado("PE");
        e1.setCep(53025020);
        e1.setLogradouro("Ladeira da Misericordia");

        try {
            em.getTransaction().begin();
            em.persist(e1);
            em.getTransaction().commit();
            System.out.println("Endereco adicionado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Aluno a1 = new Aluno();
        a1.setNomeCompleto("Luan Silva");
        a1.setEmail("luan@gmail.com");
        //a1.getEnderecos().add(e1);
        //a1.getTelefones().add(t1);

        alunoModel.create(a1);

        t1.setAluno(a1);
        try {
            em.getTransaction().begin();
            em.merge(t1);
            em.getTransaction().commit();
            System.out.println("Telefone atualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        e1.setAluno(a1);

        try {
            em.getTransaction().begin();
            em.merge(e1);
            em.getTransaction().commit();
            System.out.println("Endereco atualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Professor p1 = new Professor();
        p1.setEmail("paulo@gmail.com");
        p1.setMatricula("123");
        p1.setNomeCompleto("Paulo Borba");

        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
            System.out.println("Professor criado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MaterialCurso m1 = new MaterialCurso();
        m1.setUrl("https://www.youtube.com/java");

        try {
            em.getTransaction().begin();
            em.persist(m1);
            em.getTransaction().commit();
            System.out.println("Material de curso criado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Curso c1 = new Curso();
        //c1.setProfessor(p1);
        //c1.setMaterialCurso(m1);
        //c1.getAlunos().add(a1);
        c1.setNome("Orientacao a objetos");
        c1.setSigla("OO1");

        cursoModel.create(c1);

        a1.setCurso(c1);
        a1.getTelefones().add(t1);
        a1.getEnderecos().add(e1);

        alunoModel.update(a1);

        c1.getAlunos().add(a1);

        c1.setProfessor(p1);
        c1.setMaterialCurso(m1);

        cursoModel.update(c1);

        System.out.println(alunoModel.findById(1L));

        System.out.println(alunoModel.findAll());

        System.out.println(cursoModel.findById(1L));

        System.out.println(cursoModel.findAll());

        alunoModel.delete(a1);

        cursoModel.delete(c1);

    }
}
