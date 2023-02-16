package controle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {
	
	private Conexao con;
	
	public boolean inserir (Pessoa p) {
		/*Instaciar classe Conexao*/
		con = Conexao.getInstancia();
		
		/*abrir conexao*/
		Connection c = con.conectar();
		String query = "INSERT INTO pessoa (cpf,nome) VALUES (?,?)";
		try {
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setInt(1, 123);
			stm.setString(2, "davi");
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*fechar conexao*/
		con.fecharConexao();
		return false;
	}
	
	public boolean atualizar (Pessoa p) {
		return false;
	}
	
	public boolean deletar (Pessoa p) {
		return false;
	}
	
	public ArrayList<Pessoa> listarPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("query");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				pessoas.add(p);
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	return pessoas;
	}
	
}


