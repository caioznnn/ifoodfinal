package entidades;

public abstract class PedidoDecorator implements Entregavel {
    protected Entregavel pedido;

    public PedidoDecorator(Entregavel pedido) {
        this.pedido = pedido;
    }

    @Override
    public void avancarPara(String novoEstado) throws Exception {
        pedido.avancarPara(novoEstado);
    }

    @Override
    public String getEstadoAtual() {
        return pedido.getEstadoAtual();
    }
}