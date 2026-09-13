package projetoprincipiosdesign;

public class DescontoAluno implements Desconto {

    @Override
    public double calcular(double total) {
        return total * 0.90;
    }
}