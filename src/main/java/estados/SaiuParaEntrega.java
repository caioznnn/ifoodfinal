package estados;

import java.util.Arrays;
import java.util.List;

public class SaiuParaEntrega extends EstadoPedido {
    private static final SaiuParaEntrega instancia = new SaiuParaEntrega();

    public SaiuParaEntrega() {}

    public static SaiuParaEntrega getInstancia() {
        return instancia;
    }

    @Override
    protected void executeTransition(String nomeEstadoDestino) throws Exception {
        List<String> permitidos = Arrays.asList("Entregue", "Cancelado");
        if (permitidos.contains(nomeEstadoDestino)) {
            EstadoPedido novoEstado = EstadoStrategy.getEstado(nomeEstadoDestino);
            pedido.setEstado(novoEstado);
        } else {
            throw new IllegalStateException("Transição não permitida de SaiuParaEntrega para " + nomeEstadoDestino);
        }
    }

    @Override
    public String getNome() {
        return "Saiu para Entrega";
    }
}