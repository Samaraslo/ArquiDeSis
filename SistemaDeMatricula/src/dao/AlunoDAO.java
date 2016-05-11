package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.AlunoTO;
import factory.ConnectionFactory;

public class AlunoDAO {
	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO tbAlunos(nomeAluno, endereco, telefone, email, rg, cpf) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setCpf(rs.getString(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE tbAlunos SET nomeAluno=?, endereco=?, telefone=?, email=?, rg=?, cpf=? WHERE cpf=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM tbAlunos WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, to.getCpf());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AlunoTO carregar(String cpf) {
		AlunoTO to = new AlunoTO();
		to.setCpf(cpf);
		String sqlSelect = "SELECT nomeAluno, endereco, telefone, email, rg, cpf FROM tbAlunos WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	
	
	public ArrayList<AlunoTO> listarClientes() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT nomeAluno, endereco, telefone, email, rg, cpf FROM tbAlunos";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<AlunoTO> listarClientes(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT nomeAluno, endereco, telefone, email, rg, cpf FROM tbAlunos where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}


}
