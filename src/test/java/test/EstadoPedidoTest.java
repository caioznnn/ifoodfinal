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
    public void testInitialState() {
        assertEquals("Recebido", pedido.getEstadoAtual());
    }

    @Test
    public void testTransitionToEmPreparo() throws Exception {
        pedido.avancarPara("EmPreparo");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }

    @Test
    public void testTransitionToSaiuParaEntrega() throws Exception {
        pedido.avancarPara("EmPreparo");
        pedido.avancarPara("SaiuParaEntrega");
        assertEquals("Saiu para Entrega", pedido.getEstadoAtual());
    }

    @Test
    public void testTransitionToEntregue() throws Exception {
        pedido.avancarPara("EmPreparo");
        pedido.avancarPara("SaiuParaEntrega");
        pedido.avancarPara("Entregue");
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    @Test
    public void testTransitionToCanceladoFromRecebido() throws Exception {
        pedido.avancarPara("Cancelado");
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    @Test
    public void testInvalidTransitionFromRecebidoToEntregue() {
        try {
            pedido.avancarPara("Entregue");
        } catch (Exception e) {
            assertEquals("Recebido", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testInvalidTransitionFromEmPreparoToRecebido() throws Exception {
        pedido.avancarPara("EmPreparo");
        try {
            pedido.avancarPara("Recebido");
        } catch (Exception e) {
            assertEquals("Em Preparo", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testNoTransitionFromEntregueToCancelado() throws Exception {
        pedido.avancarPara("EmPreparo");
        pedido.avancarPara("SaiuParaEntrega");
        pedido.avancarPara("Entregue");
        try {
            pedido.avancarPara("Cancelado");
        } catch (Exception e) {
            assertEquals("Entregue", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testNoTransitionFromCanceladoToEmPreparo() throws Exception {
        pedido.avancarPara("Cancelado");
        try {
            pedido.avancarPara("EmPreparo");
        } catch (Exception e) {
            assertEquals("Cancelado", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testInvalidNullTransition() {
        try {
            pedido.avancarPara(null);
        } catch (Exception e) {
            assertEquals("Recebido", pedido.getEstadoAtual());
        }
    }
}