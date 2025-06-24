package entidades;

import estados.EstadoPedido;
import estados.EstadoStrategy;

public class PedidoBuilder {
    private EstadoPedido estado;
    private String cliente;
    private String itens;

    public PedidoBuilder setEstado(String nomeEstadoInicial) throws Exception {
        this.estado = EstadoStrategy.getEstado(nomeEstadoInicial);
        return this;
    }

    public PedidoBuilder setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder setItens(String itens) {
        this.itens = itens;
        return this;
    }

    public Pedido build() {
        if (estado == null) {
            throw new IllegalStateException("Estado inicial é obrigatório");
        }
        return new Pedido(estado, cliente, itens);
    }
}