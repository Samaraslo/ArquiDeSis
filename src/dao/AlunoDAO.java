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
		String sqlInsert = "INSERT INTO tbAlunos(nomeAluno, endereco, telefone, email, rg, cpf, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.setString(7, to.getLogin());
			stm.setString(8, to.getSenha());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setId(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE tbAlunos SET nomeAluno=?, endereco=?, telefone=?, email=?, rg=?, cpf=?, login=?, senha=? WHERE idAluno =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getCpf());
			stm.setString(7, to.getLogin());
			stm.setString(8, to.getSenha());
			stm.setInt(9, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM tbAlunos WHERE idAluno = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		String sqlSelect = "SELECT nomeAluno, endereco, telefone, email, rg, cpf, login, senha FROM tbAlunos WHERE idAluno = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					to.setLogin(rs.getString("login"));
					to.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	
	
	public ArrayList<AlunoTO> listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT idAluno, nomeAluno, endereco, telefone, email, rg, cpf, login, senha FROM tbAlunos";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("idAluno"));
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					to.setLogin(rs.getString("login"));
					to.setSenha(rs.getString("senha"));
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
	
	public ArrayList<AlunoTO> listarAlunos(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT idAluno, nomeAluno, endereco, telefone, email, rg, cpf, login, senha FROM tbAlunos where upper(nomeAluno) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("idAluno"));
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nomeAluno"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
					to.setLogin(rs.getString("login"));
					to.setSenha(rs.getString("senha"));
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
