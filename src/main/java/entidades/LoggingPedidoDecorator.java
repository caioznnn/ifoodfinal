package entidades;

public class LoggingPedidoDecorator extends PedidoDecorator {
    public LoggingPedidoDecorator(Entregavel pedido) {
        super(pedido);
    }

    @Override
    public void avancarPara(String novoEstado) throws Exception {
        super.avancarPara(novoEstado);
    }
}