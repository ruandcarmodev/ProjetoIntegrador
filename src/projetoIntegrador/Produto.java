package projetoIntegrador;

public class Produto {
	private String nome;
    private int estoque;
    private double preco;

    public Produto(String nome, int estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public boolean possuiEstoque(int quantidade) {
        return estoque >= quantidade;
    }

    public void reduzirEstoque(int quantidade) {
        estoque -= quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s | Estoque: %d | Preço: R$ %.2f",
                nome,
                estoque,
                preco);
    }
}

