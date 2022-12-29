package control;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.Scanner;

public class UsuarioController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int operacao = -1;

        for( ; operacao != 0; ){
            System.out.println("\n---- Operações ----" +
            "\n0. Sair" +
            "\n1. Cadastrar Usuário" +
            "\n2. Excluir Usuário" +
            "\n3. Alterar Informações de Usuário" +
            "\n4. Consultar por ID" +
                    "\n5. Consultar por Nome" +
                    "\n6. Consultar por Email" +
                    "\n7. Consultar por Telefone" +
            "\nOperação: ");
            operacao = input.nextInt();
            input.nextLine();

            if(operacao == 1)
                cadastrar();
            else if(operacao == 2)
                excluir();
            else if(operacao == 3)
                alterar();
            else if(operacao == 4)
                consultarPorId();
            else if(operacao == 5)
                consultaPorNome();
            else if(operacao == 6)
                consultaPorEmail();
            else if(operacao == 7)
                consultaPorTelefone();

            if(operacao != 0)
                System.out.println("\n****** Usuários Cadastrados no Sistema ******\n" +
                    UsuarioDAO.selecionarUsuarios());
        }
    }

    private static void consultaPorTelefone() {
        System.out.println("\nTelefone: ");
        String telefone = input.next();
        input.nextLine();
        System.out.println(UsuarioDAO.selecionarUsuariosTelefone(telefone));
    }

    private static void consultaPorEmail() {
        System.out.println("\nEmail: ");
        String email = input.next();
        input.nextLine();
        System.out.println(UsuarioDAO.selecionarUsuariosEmail(email));
    }

    private static void consultaPorNome() {
        System.out.println("\nNome: ");
        String nome = input.next();
        input.nextLine();
        System.out.println(UsuarioDAO.selecionarUsuariosNome(nome));
    }

    private static void consultarPorId() {
        System.out.println("\nID: ");
        long id = input.nextLong();
        input.nextLine();
        System.out.println(UsuarioDAO.selecionarUsuarioId(id));
    }

    private static void alterar() {
        Usuario usuario = null;
        for( ; usuario==null; ) {
            System.out.println("\nDigite o Código do Usuário que Deseja Alterar: ");
            long id = input.nextLong();
            input.nextLine();
            usuario = UsuarioDAO.selecionarUsuarioId(id);
            if (usuario == null)
                System.out.println("\nCódigo Inválido!");
            else
                System.out.println("\nUsuário Encontado!");
        }
        int opcao = input.nextInt();
        System.out.println("\nNome: "+ usuario.getNome() +" | Deseja mudar? (0.Sim ou 1.Não)");
        if(input.nextInt() == 0){
            input.nextLine();
            System.out.println("\nNovo Nome: ");
            usuario.setNome(input.nextLine());
        }
        System.out.println("\nEmail: "+ usuario.getEmail() +" Deseja mudar? (0.Sim ou 1.Não)");
        if(input.nextInt() == 0){
            input.nextLine();
            System.out.println("\nNovo Email: ");
            usuario.setEmail(input.nextLine());
        }
        System.out.println("\nTelefone: "+ usuario.getTelefone() +" Deseja mudar? (0.Sim ou 1.Não)");
        if(input.nextInt() == 0){
            input.nextLine();
            System.out.println("\nNovo Telefone: ");
            usuario.setTelefone(input.nextLine());
        }
        if(UsuarioDAO.alterarUsuario(usuario)){
            System.out.println("\nAlteração Realizada com Sucesso!");
        }
        else{
            System.out.println("\nErro ao Atualizar!");
        }
    }

    private static void excluir() {
        long id;
        System.out.println("\nDigite o ID do Usuário que Deseja Excluir");
        id = input.nextLong();
        input.nextLine();
        if(UsuarioDAO.deletarUsuario(id)){
            System.out.println("\nUsuário Excluído com Sucesso!");
        }
        else{
            System.out.println("\nErro ao Excluir Usuário!");
        }
    }

    private static void cadastrar() {
        Usuario usuario = new Usuario();
        System.out.println("\n********* Bem-Vindo ao Cadastro de Usuário *********\n");
        System.out.println("\nDigite o Nome do Usuário: ");
        usuario.setNome(input.nextLine());
        System.out.println("\nDigite o Email do Usuário: ");
        usuario.setEmail(input.nextLine());
        System.out.println("\nDigite o Telefone do Usuário: ");
        usuario.setTelefone(input.nextLine());

        if(UsuarioDAO.inserirUsuario(usuario)){
            System.out.println("\nUsuário Registrado com Sucesso!");
        }
        else{
            System.out.println("\nErro ao Cadastrar Usuário!");
        }
    }
}
