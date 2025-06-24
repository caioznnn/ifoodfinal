package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Pedido;
import entidades.Usuario;
import estados.Recebido;
import estados.EmPreparo;

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
    public void testUpdateRecebeMensagem() throws Exception {
        String mensagem = "Pedido está agora em estado: Em Preparo";
        pedido.setEstado(EmPreparo.getInstancia()); // Triggers notifyObservers
        assertEquals(mensagem, usuario.getUltimaMensagemRecebida());
    }
}