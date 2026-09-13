package projetoprincipiosdesign;

public class PedidoService {

    private final PedidoRepository repository = new PedidoRepository();

    public double calcularTotal(Pedido pedido, Desconto desconto) {
        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            total += item.getPreco() * item.getQuantidade();
        }

        return desconto.calcular(total);
    }

    public String obterCidadeEntrega(Pedido pedido) {
        return pedido.getCliente().getCidadeEntrega();
    }

    public void finalizarPedido(Pedido pedido, Desconto desconto, Pagamento pagamento) {
        double total = calcularTotal(pedido, desconto);

        System.out.println("Salvando pedido em arquivo...");
        repository.salvar(pedido, total);

        System.out.println("Gerando resumo do pedido...");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.printf("Total: R$ %.2f%n", total);

        pagamento.pagar(total);

        System.out.println(
                "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }
}