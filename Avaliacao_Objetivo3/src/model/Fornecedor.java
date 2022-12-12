package model;

public class Fornecedor {
    private String contato, nome;
    private int cnpj;

    public boolean manterFornec(int cnpj){
        return true;
    }

    public Fornecedor() {
    }

    public Fornecedor(String contato, String nome, int cnpj) {
        this.contato = contato;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "\nFornecedor{" +
                "contato='" + contato + '\'' +
                ", nome='" + nome + '\'' +
                ", cnpj=" + cnpj +
                '}';
    }
}
