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
    public void testCommandExecute() throws Exception {
        AdvanceStateCommand command = new AdvanceStateCommand(pedido, "EmPreparo");
        command.execute();
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }
}