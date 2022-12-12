package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {
    private int numero;
    private Calendar data;
    private double valor;
    private String tipo;
    private Vendedor vendedor;
    private List<Item> itens = new ArrayList<>();

    public boolean manterPedido(int numero){
        return true;
    }

    public boolean manterItem(int codItem){
        return true;
    }

    public Pedido() {
    }

    public Pedido(int numero, Calendar  data, double valor, String tipo, Vendedor vendedor, List<Item> itens) {
        if(numero > 0){this.numero = numero;}
        this.data = data;
        if(valor >= 0){this.valor = valor;}
        this.tipo = tipo;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Pedido(int numero, Calendar data, double valor, String tipo) {
        if(numero > 0){this.numero = numero;}
        this.data = data;
        if(valor >= 0){this.valor = valor;}
        this.tipo = tipo;
    }

    public Pedido(int numero, Calendar data, double valor) {
        if(numero > 0){this.numero = numero;}
        this.data = data;
        if(valor >= 0){this.valor = valor;}
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero > 0){this.numero = numero;}
    }

    public Calendar  getData() {
        return data;
    }

    public void setData(Calendar  data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor >= 0){this.valor = valor;}
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "\nPedido{" +
                "numero=" + numero +
                ", data=" + calendarToString(data) +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                ", vendedor=" + vendedor +
                ", itens=" + itens +
                '}';
    }

    private static String calendarToString(Calendar data) {
        if (data != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            return sdf.format(data.getTime());
        }
        return "00/00/0000 00:00";
    }
}
