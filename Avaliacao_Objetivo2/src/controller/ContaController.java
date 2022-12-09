package controller;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContaController {
    private static double auxiliar = 0.0;
    public static void main(String[] args) {
        System.out.println("------------- TÓPICO A -------------");
        ContaPoupanca cp1 = new ContaPoupanca();
        ContaPoupanca cp2 = new ContaPoupanca();
        ContaPoupanca cp3 = new ContaPoupanca();
        ContaCorrente cr1 = new ContaCorrente(100);
        ContaCorrente cr2 = new ContaCorrente(400);
        ContaCorrente cr3 = new ContaCorrente(600);
        Associado ass1 = new Associado("José", 300);
        Associado ass2 = new Associado("Maria", 600);
        Associado ass3 = new Associado("Pedro", 600);
        System.out.println(cp1); System.out.println(cp2); System.out.println(cp3);
        System.out.println(cr1); System.out.println(cr2); System.out.println(cr3);
        System.out.println(ass1); System.out.println(ass2); System.out.println(ass3);

        System.out.println("\n------------- TÓPICO B -------------");
        List<Conta> contas = new ArrayList<>();
        contas.add(cp1); contas.add(cp2); contas.add(cp3);
        contas.add(cr1); contas.add(cr2); contas.add(cr3);
        List<AssociadoVip> associados = new ArrayList<>();
        associados.add(cr1); associados.add(cr2); associados.add(cr3);
        associados.add(ass1); associados.add(ass2); associados.add(ass3);
        System.out.println(contas);
        associados.forEach((p) -> {
            if(p instanceof Associado) {
                System.out.println(p);;
            }
        });

        System.out.println("\n------------- TÓPICO C -------------");
        cp1.deposita(1000); System.out.println("Depósito:"+cp1);
        cp1.atualiza(5); System.out.println("Atualização:"+cp1);
        cp1.saca(50); System.out.println("Saque:"+cp1);

        System.out.println("\n------------- TÓPICO D -------------");
        cr1.deposita(500); System.out.println("Depósito:"+cr1);
        cr1.saca(400); System.out.println("Saque:"+cr1);

        System.out.println("\n------------- TÓPICO E -------------");
        System.out.println(associados);

        System.out.println("\n------------- TÓPICO F -------------");
        System.out.println("Ordem Decrescente Cotas:");
        associados.sort(Comparator.comparing(AssociadoVip::getQdeCotas).reversed());
        System.out.println(associados);

        System.out.println("\nAssociados c/ maior Quantidade de Cotas:");
        associados.forEach((p) -> {
            if(p.getQdeCotas()>auxiliar){
                auxiliar = p.getQdeCotas();
            }
        });

        associados.forEach((p) -> {
            if(p.getQdeCotas() == auxiliar){
                System.out.println(p);
            }
        });

        System.out.println("\n------------- TÓPICO G -------------");
        cp2.deposita(200); cp3.deposita(300);
        cr2.deposita(400); cr3.deposita(500);

        System.out.println("\nContas Ordem Decrescente Saldo:");
        contas.sort(Comparator.comparing(Conta::getSaldo).reversed());
        System.out.println(contas);

        System.out.println("\nAssociados que possuem Conta");
        contas.forEach((p) -> {
            if(p instanceof ContaCorrente) {
                System.out.println(p);;
            }
        });
        auxiliar = 0.0;
        System.out.println("\nContas c/ maior Saldo:");
        contas.forEach((p) -> {
            if(p.getSaldo() > auxiliar){
                auxiliar = p.getSaldo();
            }
        });

        contas.forEach((p) -> {
            if(p.getSaldo() == auxiliar){
                System.out.println(p);
            }
        });
    }
}
