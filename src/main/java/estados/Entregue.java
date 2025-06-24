package estados;

public class Entregue extends EstadoPedido {
    private static final Entregue instancia = new Entregue();

    private Entregue() {}

    public static Entregue getInstancia() {
        return instancia;
    }

    @Override
    protected void executeTransition(String nomeEstadoDestino) {
        throw new IllegalStateException("Pedido já foi entregue. Não é possível alterar estado.");
    }

    @Override
    public String getNome() {
        return "Entregue";
    }
}