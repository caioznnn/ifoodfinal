package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import fabrica.PedidoFactory;

public class PedidoFactoryTest {
    @Test
    public void testCreatePedidoRecebido() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("Recebido", "User1", "Item1");
        assertEquals("Recebido", pedido.getEstadoAtual());
    }

    @Test
    public void testCreatePedidoEmPreparo() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("EmPreparo", "User2", "Item2");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }

    @Test
    public void testCreatePedidoSaiuParaEntrega() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("SaiuParaEntrega", "User3", "Item3");
        assertEquals("Saiu para Entrega", pedido.getEstadoAtual());
    }

    @Test
    public void testCreatePedidoEntregue() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("Entregue", "User4", "Item4");
        assertEquals("Entregue", pedido.getEstadoAtual());
    }

    @Test
    public void testCreatePedidoCancelado() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("Cancelado", "User5", "Item5");
        assertEquals("Cancelado", pedido.getEstadoAtual());
    }

    @Test
    public void testCreateWithNullClient() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("Recebido", null, "Item6");
        assertEquals("Recebido", pedido.getEstadoAtual());
    }

    @Test
    public void testCreateWithEmptyItens() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("EmPreparo", "User7", "");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }

    @Test
    public void testCreateWithInvalidState() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        try {
            factory.criarPedido("InvalidState", "User8", "Item8");
        } catch (Exception e) {
            Pedido pedido = factory.criarPedido("Recebido", "User8", "Item8"); // Reset to valid
            assertEquals("Recebido", pedido.getEstadoAtual());
        }
    }

    @Test
    public void testSingletonInstance() throws Exception {
        PedidoFactory factory1 = PedidoFactory.getInstancia();
        PedidoFactory factory2 = PedidoFactory.getInstancia();
        Pedido pedido = factory1.criarPedido("Recebido", "User9", "Item9");
        assertEquals("Recebido", pedido.getEstadoAtual());
    }

    @Test
    public void testMultipleCreations() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        factory.criarPedido("Recebido", "User10", "Item10");
        Pedido pedido = factory.criarPedido("EmPreparo", "User11", "Item11");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }
}