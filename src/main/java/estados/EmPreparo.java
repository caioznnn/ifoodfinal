package estados;

import java.util.Arrays;
import java.util.List;

public class EmPreparo extends EstadoPedido {
    private static final EmPreparo instancia = new EmPreparo();

    public EmPreparo() {}

    public static EmPreparo getInstancia() {
        return instancia;
    }

    @Override
    protected void executeTransition(String nomeEstadoDestino) throws Exception {
        List<String> permitidos = Arrays.asList("SaiuParaEntrega", "Cancelado");
        if (permitidos.contains(nomeEstadoDestino)) {
            EstadoPedido novoEstado = EstadoStrategy.getEstado(nomeEstadoDestino);
            pedido.setEstado(novoEstado);
        } else {
            throw new IllegalStateException("Transição não permitida de EmPreparo para " + nomeEstadoDestino);
        }
    }

    @Override
    public String getNome() {
        return "Em Preparo";
    }
}