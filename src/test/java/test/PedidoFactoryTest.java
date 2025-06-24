package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import fabrica.PedidoFactory;

public class PedidoFactoryTest {
    @Test
    public void testCriarPedidoComEstadoInicial() throws Exception {
        PedidoFactory factory = PedidoFactory.getInstancia();
        Pedido pedido = factory.criarPedido("Recebido", "TestUser", "Item1");
        assertEquals("Recebido", pedido.getEstadoAtual());
    }
}