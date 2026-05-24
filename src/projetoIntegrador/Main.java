package projetoIntegrador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Conexao.conectar();
		
		Scanner scanner = new Scanner(System.in);

        Cadastro cadastro = new Cadastro();
        Compra compra = new Compra();

        System.out.println("===== SISTEMA DE MERCADO =====\n");

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        compra.definirCliente(nomeCliente);

        boolean continuar = true;

        while (continuar) {

            cadastro.listarProdutos();

            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            Produto produto = cadastro.buscarProduto(nomeProduto);

            if (produto == null) {
                System.out.println("Produto não encontrado.\n");
                continue;
            }

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            compra.adicionarItem(produto, quantidade);

            System.out.print("Deseja adicionar mais produtos? (s/n): ");
            String resposta = scanner.nextLine();

            continuar = resposta.equalsIgnoreCase("s");
        }
        
        

        compra.finalizarCompra();

        scanner.close();
    }
	}

