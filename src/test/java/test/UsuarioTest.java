package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import entidades.Usuario;
import estados.Cancelado;
import estados.EmPreparo;
import estados.Entregue;
import estados.Recebido;
import estados.SaiuParaEntrega;

public class UsuarioTest {
    private Usuario usuario;
    private Pedido pedido;

    @BeforeEach
    public void setUp() throws Exception {
        usuario = new Usuario("TestUser");
        pedido = new Pedido(Recebido.getInstancia());
        pedido.addObserver(usuario);
    }

    @Test
    public void testInitialMessage() {
        assertEquals("Nenhuma mensagem recebida ainda", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testStateChangeToEmPreparo() throws Exception {
        pedido.setEstado(EmPreparo.getInstancia());
        assertEquals("Pedido está agora em estado: Em Preparo", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testStateChangeToSaiuParaEntrega() throws Exception {
        pedido.setEstado(EmPreparo.getInstancia());
        pedido.setEstado(SaiuParaEntrega.getInstancia());
        assertEquals("Pedido está agora em estado: Saiu para Entrega", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testStateChangeToEntregue() throws Exception {
        pedido.setEstado(EmPreparo.getInstancia());
        pedido.setEstado(SaiuParaEntrega.getInstancia());
        pedido.setEstado(Entregue.getInstancia());
        assertEquals("Pedido está agora em estado: Entregue", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testStateChangeToCancelado() throws Exception {
        pedido.setEstado(Cancelado.getInstancia());
        assertEquals("Pedido está agora em estado: Cancelado", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testMultipleStateChanges() throws Exception {
        pedido.setEstado(EmPreparo.getInstancia());
        pedido.setEstado(SaiuParaEntrega.getInstancia());
        assertEquals("Pedido está agora em estado: Saiu para Entrega", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testNoChangeAfterRemoveObserver() throws Exception {
        pedido.deleteObserver(usuario);
        pedido.setEstado(EmPreparo.getInstancia());
        assertEquals("Nenhuma mensagem recebida ainda", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testObserverReaddedAfterChange() throws Exception {
        pedido.deleteObserver(usuario);
        pedido.setEstado(EmPreparo.getInstancia());
        pedido.addObserver(usuario);
        pedido.setEstado(SaiuParaEntrega.getInstancia());
        assertEquals("Pedido está agora em estado: Saiu para Entrega", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testNoUpdateOnInvalidState() throws Exception {
        try {
            pedido.setEstado(null);
        } catch (Exception e) {
            assertEquals("Nenhuma mensagem recebida ainda", usuario.getUltimaMensagemRecebida());
        }
    }

    @Test
    public void testObserverWithMultipleObservers() throws Exception {
        Usuario usuario2 = new Usuario("TestUser2");
        pedido.addObserver(usuario2);
        pedido.setEstado(EmPreparo.getInstancia());
        assertEquals("Pedido está agora em estado: Em Preparo", usuario.getUltimaMensagemRecebida());
    }
}