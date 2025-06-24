package estados;

import java.util.Arrays;
import java.util.List;

public class Recebido extends EstadoPedido {
    private static final Recebido instancia = new Recebido();

    private Recebido() {}

    public static Recebido getInstancia() {
        return instancia;
    }

    @Override
    protected void executeTransition(String nomeEstadoDestino) throws Exception {
        List<String> permitidos = Arrays.asList("EmPreparo", "Cancelado");
        if (permitidos.contains(nomeEstadoDestino)) {
            EstadoPedido novoEstado = EstadoStrategy.getEstado(nomeEstadoDestino);
            pedido.setEstado(novoEstado);
        } else {
            throw new IllegalStateException("Transição não permitida de Recebido para " + nomeEstadoDestino);
        }
    }

    @Override
    public String getNome() {
        return "Recebido";
    }
}