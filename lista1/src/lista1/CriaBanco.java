package lista1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {

	 public static void main(String[] args) {

	        // Definindo as credenciais de acesso ao banco de dados
	        String url = "jdbc:mysql://localhost:3306/"; // URL do banco de dados
	        String user = "root"; // Nome do usuário
	        String password = "senha"; // Senha do usuário

	        // Conectando ao banco de dados
	        try (Connection conn = DriverManager.getConnection(url, user, password)) {

	            // Criando um novo banco de dados
	            String nomeBanco = "meu_banco";
	            String sqlCreateDatabase = "CREATE DATABASE IF NOT EXISTS " + nomeBanco;
	            try (Statement stmt = conn.createStatement()) {
	                stmt.execute(sqlCreateDatabase);
	            }

	            // Criando uma tabela com três colunas, incluindo a chave primária
	            String nomeTabela = "minha_tabela";
	            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + nomeBanco + "." + nomeTabela +
	                    " (id INT PRIMARY KEY AUTO_INCREMENT, coluna1 VARCHAR(50), coluna2 VARCHAR(50))";
	            try (Statement stmt = conn.createStatement()) {
	                stmt.execute(sqlCreateTable);
	            }

	            System.out.println("Banco de dados e tabela criados com sucesso!");

	        } catch (SQLException ex) {
	            System.out.println("Erro ao conectar ou criar banco de dados: " + ex.getMessage());
	        }
	    }
}
