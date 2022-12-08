package controller;

import model.Aluno;

import java.util.*;

public class AlunoController {
    public static void main(String[] args) {
        // ---------------- TÓPICO A ----------------
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno(1, 123, "José", "Pereira", "jose@gmail.com" );
        Aluno aluno4 = new Aluno(2, 456, "Amanda", "Silva", "amanda@gmail.com");
        Aluno aluno5 = new Aluno(3, "Caio");
        Aluno aluno6 = new Aluno(4, "Marina");

        System.out.println(aluno1); System.out.println(aluno2); System.out.println(aluno3);
        System.out.println(aluno4); System.out.println(aluno5); System.out.println(aluno6);

        // ---------------- TÓPICO B ----------------
        aluno1.setId(5); aluno1.setNome("Guilherme"); aluno1.setSobrenome("Barbosa");
        aluno1.setCpf(789); aluno1.setEmail("gui@gmail.com");

        aluno2.setId(6); aluno2.setNome("Miguel"); aluno2.setSobrenome("Vieira");
        aluno2.setCpf(012); aluno2.setEmail("miguel@gmail.com");

        System.out.println(aluno1.getId()); System.out.println(aluno1.getNome());
        System.out.println(aluno1.getSobrenome()); System.out.println(aluno1.getCpf());
        System.out.println(aluno1.getEmail());

        System.out.println(aluno2.getId()); System.out.println(aluno2.getNome());
        System.out.println(aluno2.getSobrenome()); System.out.println(aluno2.getCpf());
        System.out.println(aluno2.getEmail());

        System.out.println("\n--------- Tópico 2 ---------");
        System.out.println("\n--------- Ordem Crescente List ---------");
        List<Aluno> alunoList = new ArrayList<>();
        alunoList.add(aluno1); alunoList.add(aluno2); alunoList.add(aluno3);
        alunoList.add(aluno4); alunoList.add(aluno5); alunoList.add(aluno6);
        alunoList.sort(Comparator.comparing(Aluno::getId));
        System.out.println(alunoList);

        System.out.println("\n--------- Tipo <Map> ---------");
        Map<Integer, Aluno> alunoMap = new HashMap<>();
        alunoMap.put(aluno1.getId(), aluno1);  alunoMap.put(aluno2.getId(), aluno2);
        alunoMap.put(aluno3.getId(), aluno3);  alunoMap.put(aluno4.getId(), aluno4);
        alunoMap.put(aluno5.getId(), aluno5);  alunoMap.put(aluno6.getId(), aluno6);
        System.out.println(alunoMap);

        System.out.println("\n--------- Ordem Decrescente List ---------");
        alunoList.sort(Comparator.comparing(Aluno::getId).reversed());
        System.out.println(alunoList);

        System.out.println("\n--------- Pesquisa ID 5 List/Map ---------");
        Aluno encontrei = alunoList.stream().filter(p -> p.getId() == 5).findAny().orElse(null);
        System.out.println(encontrei);
        System.out.println(alunoMap.get(5));
    }
}
