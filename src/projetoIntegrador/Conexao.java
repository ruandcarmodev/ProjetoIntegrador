package projetoIntegrador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String URL =
            "jdbc:mysql://localhost:3306/sistema_compras";

    private static final String USUARIO =
            "root";

    private static final String SENHA =
            "r21034002N*";

    public static Connection conectar() {

        try {

            Connection conexao =
                    DriverManager.getConnection(
                            URL,
                            USUARIO,
                            SENHA
                    );

            System.out.println("Conectado ao banco!");

            return conexao;

        } catch (Exception e) {

            System.out.println("Erro na conexão!");

            e.printStackTrace();

            return null;
        }
    }
}
