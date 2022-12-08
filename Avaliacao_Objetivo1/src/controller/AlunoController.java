package controller;

import model.Aluno;

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
    }
}
