package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import entidades.PedidoBuilder;
import entidades.Usuario;

public class PedidoTest {
    private Pedido pedido;
    private Usuario usuario;

    @BeforeEach
    public void setUp() throws Exception {
        PedidoBuilder builder = new PedidoBuilder().setEstado("Recebido");
        pedido = builder.build();
        usuario = new Usuario("TestUser");
        pedido.addObserver(usuario);
    }

    @Test
    public void testTransicaoValidaRecebidoParaEmPreparo() throws Exception {
        pedido.avancarPara("EmPreparo");
        assertEquals("Em Preparo", pedido.getEstadoAtual());
    }
}