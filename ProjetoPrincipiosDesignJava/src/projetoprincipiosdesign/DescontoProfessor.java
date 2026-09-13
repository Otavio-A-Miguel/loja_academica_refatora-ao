package projetoprincipiosdesign;

public class DescontoProfessor implements Desconto {

    @Override
    public double calcular(double total) {
        return total * 0.85;
    }
}