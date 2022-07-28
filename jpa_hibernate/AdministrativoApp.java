package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);


        // create
        produtoModel.create(p1);

        // findAll
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // findById
        Produto found = produtoModel.findById(1);
        System.out.println(found);

        //update
        p1.setPreco(250.0);
        p1.setQuantidade(50);
        p1.setStatus(false);
        produtoModel.update(p1);
        System.out.println(produtoModel.findById(1));

        //delete
        produtoModel.delete(p1);
        System.out.println(produtoModel.findAll().size());


        //Pessoas

        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pe1 = new Pessoa();
        pe1.setNome("Albert");
        pe1.setCpf("1234567890");
        pe1.setEmail("albert@gmail.com");
        pe1.setIdade(23);
        pe1.setDataDeNascimento(new Date("21/12/1998"));


        // create
        pessoaModel.create(pe1);

        // findAll
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + produtos.size());

        // findById
        Pessoa pFound = pessoaModel.findById(1);
        System.out.println(pFound);

        //update
        pe1.setEmail("albert2@gmail.com");
        pessoaModel.update(pe1);
        System.out.println(pessoaModel.findById(1));

        //delete
        pessoaModel.delete(pe1);
        System.out.println(pessoaModel.findAll().size());

    }
}
