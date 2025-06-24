package entidades;

import estados.EstadoPedido;
import estados.Recebido;

import java.util.Observable;

public class Pedido extends Observable implements Entregavel {
    private EstadoPedido estado;
    private String cliente;
    private String itens;

    public Pedido(EstadoPedido estado, String cliente, String itens) {
        this.estado = estado;
        this.estado.setPedido(this);
        this.cliente = cliente;
        this.itens = itens;
    }

    public Pedido(Recebido instancia) {
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        this.estado.setPedido(this);
        setChanged();
        notifyObservers("Pedido está agora em estado: " + estado.getNome());
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public void avancarPara(String nomeEstadoDestino) throws Exception {
        estado.avancarPara(nomeEstadoDestino);
    }

    @Override
    public String getEstadoAtual() {
        return estado.getNome();
    }

    public String getCliente() {
        return cliente;
    }

    public String getItens() {
        return itens;
    }
}