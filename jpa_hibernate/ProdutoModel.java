package models;


import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {

    public void create(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch(Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel inserir o produto");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<Produto> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Produto> produtos = null;
        try {
            produtos = entityManager.createQuery("FROM Produto").getResultList();
        } catch(Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel resgatar a lista de produtos");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return produtos;
    }

    public Produto findById(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Produto produto = null;
        try {
            produto = entityManager.find(Produto.class, id);
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel resgatar o produto");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return produto;
    }

    public void update(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel atualizar o produto");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            produto = entityManager.find(Produto.class, produto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.close();
            entityManagerFactory.close();
            System.out.println("Nao foi possivel remover o produto");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
