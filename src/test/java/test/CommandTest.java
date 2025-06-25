package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import entidades.PedidoBuilder;
import comandos.AdvanceStateCommand;

public class CommandTest {
    private Pedido pedido;

    @BeforeEach
    public void setUp() throws Exception {
        PedidoBuilder builder = new PedidoBuilder().setEstado("Recebido");
        pedido = builder.build();
    }

    @Test
    public void testCommandExecuteToEmPreparo() throws Exception {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "EmPreparo");
        command.execute();
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }

    @Test
    public void testCommandExecuteToSaiuParaEntrega() throws Exception {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "EmPreparo");
        command.execute();
        command = new AdvanceStateCommand(pedido, "SaiuParaEntrega");
        command.execute();
        assertEquals("Saiu para Entrega", pedido.getEstadoAtual());
    }

    @Test
    public void testCommandExecuteToEntregue() throws Exception {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "EmPreparo");
        command.execute();
        command = new AdvanceStateCommand(pedido, "SaiuParaEntrega");
        command.execute();
        command = new AdvanceStateCommand(pedido, "Entregue");
        command.execute();
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    @Test
    public void testCommandExecuteToCancelado() throws Exception {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "Cancelado");
        command.execute();
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    @Test
    public void testInvalidCommandExecute() {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "InvalidState");
        try {
            command.execute();
        } catch (Exception e) {
            assertEquals("Recebido", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testMultipleCommands() throws Exception {
        AdvanceStateCommand command1 = new AdvanceStateCommand(pedido, "EmPreparo");
        command1.execute();
        AdvanceStateCommand command2 = new AdvanceStateCommand(pedido, "SaiuParaEntrega");
        command2.execute();
        assertEquals("Saiu para Entrega", pedido.getEstadoAtual());
    }
}