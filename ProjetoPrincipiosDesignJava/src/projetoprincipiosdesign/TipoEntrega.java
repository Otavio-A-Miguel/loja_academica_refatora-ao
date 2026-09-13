package projetoprincipiosdesign;

public interface TipoEntrega {
    boolean disponivelPara(double total);
    double calcularFrete(double total);
}