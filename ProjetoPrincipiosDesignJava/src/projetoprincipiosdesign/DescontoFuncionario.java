package projetoprincipiosdesign;

public class DescontoFuncionario implements Desconto {

    @Override
    public double calcular(double total) {
        return total * 0.80;
    }
}