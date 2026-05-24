package projetoIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	private String nomeCliente;
    private List<ItemCompra> itens;

    public Compra() {
        itens = new ArrayList<>();
    }

    public void definirCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (!produto.possuiEstoque(quantidade)) {
            System.out.println("Estoque insuficiente para: " + produto.getNome());
            return;
        }

        ItemCompra item = new ItemCompra(produto, quantidade);

        itens.add(item);

        produto.reduzirEstoque(quantidade);

        System.out.println(
                quantidade + "x " + produto.getNome() + " adicionado(s) ao carrinho."
        );
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemCompra item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void finalizarCompra() {

        System.out.println("\n========= CUPOM =========");
        System.out.println("Cliente: " + nomeCliente);

        for (ItemCompra item : itens) {

            System.out.printf(
                    "%s | Quantidade: %d | Subtotal: R$ %.2f%n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.calcularSubtotal()
            );
        }

        System.out.printf("\nTOTAL: R$ %.2f%n", calcularTotal());
        System.out.println("=========================\n");
    }
}
