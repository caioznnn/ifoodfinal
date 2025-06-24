package fabrica;

import entidades.Pedido;
import entidades.PedidoBuilder;

public class PedidoFactory {
    private static final PedidoFactory instancia = new PedidoFactory();

    private PedidoFactory() {}

    public static PedidoFactory getInstancia() {
        return instancia;
    }

    public Pedido criarPedido(String nomeEstadoInicial, String cliente, String itens) throws Exception {
        PedidoBuilder builder = new PedidoBuilder()
                .setEstado(nomeEstadoInicial)
                .setCliente(cliente)
                .setItens(itens);
        return builder.build();
    }
}