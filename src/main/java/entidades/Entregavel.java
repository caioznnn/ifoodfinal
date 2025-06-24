package entidades;

public interface Entregavel {
    void avancarPara(String novoEstado) throws Exception;
    String getEstadoAtual();
}