package estados;

public class EstadoStrategy {
    public static EstadoPedido getEstado(String nomeEstado) throws Exception {
        switch (nomeEstado) {
            case "Recebido": return Recebido.getInstancia();
            case "EmPreparo": return EmPreparo.getInstancia();
            case "SaiuParaEntrega": return SaiuParaEntrega.getInstancia();
            case "Entregue": return Entregue.getInstancia();
            case "Cancelado": return Cancelado.getInstancia();
            default: throw new IllegalArgumentException("Estado desconhecido: " + nomeEstado);
        }
    }
}