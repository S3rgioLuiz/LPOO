package controller;

import model.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LojaController {
    private static double auxiliar = 0;
    public static void main(String[] args) {
        //---------------------------------- TÓPICO B ----------------------------------

        //****************** PEDIDO 1 ******************
        Vendedor vendedor1 = new Vendedor(1, "Mario Henrique", "R. Santos Dumont",
                "Centro", "96020380", "Pelotas", "Rio Grande do Sul", "xxxx");

        Produto produto1 = new Produto(101, 50, "Arroz", 5);
        Item item1 = new Item(201, 5, 15, produto1);

        Produto produto2 = new Produto(102, 50, "Feijão", 7.5);
        Item item2 = new Item(202, 10, 12, produto2);

        Produto produto3 = new Produto(103, 50, "Milho Verde", 2.75);
        Item item3 = new Item(203, 15, 0, produto3);

        List<Item> itens = new ArrayList<>();
        itens.add(item1); itens.add(item2); itens.add(item3);

        Pedido pedido1 = new Pedido();
        pedido1.setNumero(1); pedido1.setData(new GregorianCalendar(2022, 9, 8));
        pedido1.setTipo("Atendido"); pedido1.setVendedor(vendedor1); pedido1.setItens(itens);

        pedido1.getItens().forEach(p -> {
            p.setTotalItem(p.getQuantidade() * p.getProduto().getPreco() -
                    ((p.getQuantidade() * p.getProduto().getPreco()) * p.getDesconto()/100));
            pedido1.setValor(pedido1.getValor() + p.getTotalItem());
        });

        //****************** PEDIDO 2 ******************
        Vendedor vendedor2 = new Vendedor(2, "Luan Vieira", "Av. Bento Gonçalves",
                "Centro", "12345678", "Pelotas", "Rio Grande do Sul", "xxxx");

        Produto produto4 = new Produto(104, 50, "Massa", 2);
        Item item4 = new Item(204, 7, 5, produto4);

        Produto produto5 = new Produto(105, 50, "Ervilha", 1.75);
        Item item5 = new Item(205, 10, 5, produto5);

        List<Item> itens2 = new ArrayList<>();
        itens2.add(item4); itens2.add(item5);

        Pedido pedido2 = new Pedido();
        pedido2.setNumero(2); pedido2.setData(new GregorianCalendar(2022, 9, 8));
        pedido2.setTipo("Atendido"); pedido2.setVendedor(vendedor2); pedido2.setItens(itens2);

        pedido2.getItens().forEach(p -> {
            p.setTotalItem(p.getQuantidade() * p.getProduto().getPreco() -
                    ((p.getQuantidade() * p.getProduto().getPreco()) * p.getDesconto()/100));
            pedido2.setValor(pedido2.getValor() + p.getTotalItem());
        });

        //****************** COLEÇÃO PEDIDOS ******************
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1); pedidos.add(pedido2);
        System.out.println(pedidos);
        System.out.println(); //ESPAÇAMENTO

        //****************** ESTOQUE PÓS VENDAS ******************
        pedidos.forEach(p -> {
            p.getItens().forEach(f -> {
                f.getProduto().setQuantidade(f.getProduto().getQuantidade() - f.getQuantidade());
                System.out.println("Produto: "+ f.getProduto().getNome() +" | Estoque: "+ f.getProduto().getQuantidade());
            });
        });
        System.out.println(); //ESPAÇAMENTO

        //---------------------------------- TÓPICO C ----------------------------------

        //****************** FORNECIMENTO 1 ******************
        Produto produto6 = new Produto(106, 50, "Meia", 9.90);
        Fornecedor fornecedor1 = new Fornecedor("abcd@gmail.com", "ABCD", 123);
        Fornecimento fornecimento1 = new Fornecimento(new GregorianCalendar(2022, 8, 25),
                (produto6.getPreco() * produto6.getQuantidade()) * 0.5); //TIRANDO O LUCRO E AS TRIBUTAÇÕES.
        fornecimento1.setFornecedor(fornecedor1); fornecimento1.setProduto(produto6);

        //****************** FORNECIMENTO 2 ******************
        Produto produto7 = new Produto(107, 50, "Cueca", 19.90);
        Fornecimento fornecimento2 = new Fornecimento(new GregorianCalendar(2022, 8, 25),
                (produto7.getPreco() * produto7.getQuantidade()) * 0.5); //TIRANDO O LUCRO E AS TRIBUTAÇÕES.
        fornecimento2.setFornecedor(fornecedor1); fornecimento2.setProduto(produto7);

        //****************** COLEÇÃO FORNECIMENTO ******************
        List<Fornecimento> fornecimentos = new ArrayList<>();
        fornecimentos.add(fornecimento1); fornecimentos.add(fornecimento2);

        fornecimentos.forEach(p -> {
            auxiliar += p.getValorTotal();
        });

        System.out.println(fornecimentos);
        System.out.println("Custo Total dos Fornecimentos: "+ auxiliar);
    }
}
