package estados;

import entidades.Pedido;

public abstract class EstadoPedido {
    protected Pedido pedido;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public final void avancarPara(String nomeEstadoDestino) throws Exception {
        validateTransition(nomeEstadoDestino);
        executeTransition(nomeEstadoDestino);
    }

    protected abstract void executeTransition(String nomeEstadoDestino) throws Exception;

    protected void validateTransition(String nomeEstadoDestino) {
        if (nomeEstadoDestino == null || nomeEstadoDestino.trim().isEmpty()) {
            throw new IllegalArgumentException("Estado de destino inválido");
        }
    }

    public abstract String getNome();
}