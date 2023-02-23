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
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*fechar conexao*/
		con.fecharConexao();
		return false;
	}
	
	public boolean atualizar (Pessoa p) {
		/*Instaciar classe Conexao*/
		con = Conexao.getInstancia();
		
		/*abrir conexao*/
		Connection c = con.conectar();
		
	
		
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletar (Pessoa p) {
		/*Instaciar classe Conexao*/
		con = Conexao.getInstancia();
		
		/*abrir conexao*/
		Connection c = con.conectar();
		
		try {
			String query = "DELETE FROM pessoa WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, p.getCpf());
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		con.fecharConexao();

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


