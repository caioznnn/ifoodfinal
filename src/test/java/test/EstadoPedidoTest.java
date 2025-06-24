package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import entidades.PedidoBuilder;

public class EstadoPedidoTest {
    private Pedido pedido;

    @BeforeEach
    public void setUp() throws Exception {
        PedidoBuilder builder = new PedidoBuilder().setEstado("Recebido");
        pedido = builder.build();
    }

    @Test
    public void testTransicaoRecebidoParaEmPreparo() throws Exception {
        pedido.avancarPara("EmPreparo");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }
}