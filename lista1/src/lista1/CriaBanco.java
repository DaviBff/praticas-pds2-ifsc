package lista1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {


    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            // Faz a conexão com o banco de dados
            String url = "jdbc:mysql://localhost/";
            String user = "root";
            String password = "aluno";
            conn = DriverManager.getConnection(url, user, password);
            
            // Cria o banco de dados
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE meubanco";
            stmt.executeUpdate(sql);
            
            // Seleciona o banco de dados criado
            sql = "USE meubanco";
            stmt.executeUpdate(sql);
            
            // Cria a tabela
            sql = "CREATE TABLE minhaTabela " +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    " coluna1 VARCHAR(255), " +
                    " coluna2 VARCHAR(255), " +
                    " PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            
            System.out.println("Banco de dados e tabela criados com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println("Erro ao criar banco de dados ou tabela: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão com o banco de dados: " + ex.getMessage());
            }
        }
        
    }
}