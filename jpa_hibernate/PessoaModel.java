package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch(Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel inserir a pessoa");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Pessoa> pessoas = null;
        try {
            pessoas = entityManager.createQuery("FROM Pessoa").getResultList();
        } catch(Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel resgatar a lista de pessoas");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return pessoas;
    }

    public Pessoa findById(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pessoa pessoa = null;
        try {
            pessoa = entityManager.find(Pessoa.class, id);
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel resgatar a pessoa");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return pessoa;
    }

    public void update(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel atualizar a pessoa");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel remover a pessoa");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
