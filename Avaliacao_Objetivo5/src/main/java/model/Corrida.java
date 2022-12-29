package model;

public class Corrida {
    private Long id;
    private String tipoPagamento, detalhesPagamento;
    private int attribute9;

    private Motorista motorista;

    private Usuario usuario;

    public Corrida() {
    }

    public Corrida(Long id, String tipoPagamento, String detalhesPagamento, int attribute9, Motorista motorista, Usuario usuario) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.detalhesPagamento = detalhesPagamento;
        this.attribute9 = attribute9;
        this.motorista = motorista;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDetalhesPagamento() {
        return detalhesPagamento;
    }

    public void setDetalhesPagamento(String detalhesPagamento) {
        this.detalhesPagamento = detalhesPagamento;
    }

    public int getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(int attribute9) {
        this.attribute9 = attribute9;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "\nCorrida{" +
                "id=" + id +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                ", detalhesPagamento='" + detalhesPagamento + '\'' +
                ", attribute9=" + attribute9 +
                ", motorista=" + motorista +
                ", usuario=" + usuario +
                '}';
    }
}
