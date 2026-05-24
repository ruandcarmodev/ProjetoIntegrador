package projetoIntegrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class Cadastro {
	private Map<String, Produto> produtos;

    public Cadastro() {
        produtos = new HashMap<>();
        carregarProdutos();
    }

    private void carregarProdutos() {

        adicionarProduto(new Produto("Refrigerante 2L", 11, 9.00));
        adicionarProduto(new Produto("Caixa de Chocolate", 10, 7.50));
        adicionarProduto(new Produto("Bolacha", 17, 2.50));
        adicionarProduto(new Produto("Arroz", 5, 13.00));
        adicionarProduto(new Produto("Detergente", 14, 9.25));
    }

    public void adicionarProduto(Produto produto) {
    	produtos.put(produto.getNome().toLowerCase(), produto);

        String sql =
                "INSERT INTO produto(nome, estoque, preco) VALUES (?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getEstoque());
            stmt.setDouble(3, produto.getPreco());

            int linhas = stmt.executeUpdate();

            System.out.println("Linhas inseridas: " + linhas);

        } catch (Exception e) {

            System.out.println("Erro ao salvar produto!");

            e.printStackTrace();
        }
    }

    public Produto buscarProduto(String nome) {
        return produtos.get(nome.toLowerCase());
    }

    public void listarProdutos() {

        System.out.println("\n===== PRODUTOS DISPONÍVEIS =====");

        for (Produto produto : produtos.values()) {
            System.out.println(produto);
        }

        System.out.println();
    }
}
