package comandos;

import entidades.Pedido;

public class AdvanceStateCommand implements Command {
    private Pedido pedido;
    private String novoEstado;
    private String estadoAnterior;

    public AdvanceStateCommand(Pedido pedido, String novoEstado) {
        this.pedido = pedido;
        this.novoEstado = novoEstado;
    }

    @Override
    public void execute() throws Exception {
        estadoAnterior = pedido.getEstadoAtual();
        pedido.avancarPara(novoEstado);
    }

    @Override
    public void undo() throws Exception {
        if (estadoAnterior != null) {
            pedido.avancarPara(estadoAnterior);
        }
    }
}