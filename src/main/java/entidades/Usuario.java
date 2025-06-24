package entidades;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaMensagemRecebida;

    public Usuario(String nome) {
        this.nome = nome;
        this.ultimaMensagemRecebida = "Nenhuma mensagem recebida ainda";
    }

    public String getUltimaMensagemRecebida() {
        return ultimaMensagemRecebida;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            this.ultimaMensagemRecebida = (String) arg;
        }
    }

    public String getNome() {
        return nome;
    }
}