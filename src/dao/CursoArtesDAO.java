package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.CursoArtesTO;
import factory.ConnectionFactory;
 
public class CursoArtesDAO {
	public void incluir(CursoArtesTO to) {
		String sqlInsert = "INSERT INTO tbArtes(nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas, valorCurso, descricaoMaterial, nomeDosLivros, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getDataInicio());
			stm.setString(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setString(5, to.getNumeroVagas());
			stm.setString(6, to.getValor());
			stm.setString(7, to.getDescricaoMaterial());
			stm.setString(8, to.getNomeLivrosUtilizados());
			stm.setString(9, to.getDisponibilidade());
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
	
	public void atualizar(CursoArtesTO to) {
		String sqlUpdate = "UPDATE tbArtes SET nomeCurso=?, dataInicio=?, dataTermino=?, horarioPrevisto=?, numeroDeVagas=?, valorCurso=?, descricaoMaterial=?, nomeDosLivros=?, disponivel=? WHERE idArtes =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getDataInicio());
			stm.setString(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setString(5, to.getNumeroVagas());
			stm.setString(6, to.getValor());
			stm.setString(7, to.getDescricaoMaterial());
			stm.setString(8, to.getNomeLivrosUtilizados());
			stm.setString(9, to.getDisponibilidade());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(CursoArtesTO to) {
		String sqlDelete = "DELETE FROM tbArtes WHERE idArtes = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CursoArtesTO carregar(int id) {
		CursoArtesTO to = new CursoArtesTO();
		//to.setId(id);
		String sqlSelect = "SELECT * FROM tbArtes WHERE idArtes = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
					to.setNome(rs.getString(2));
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setDescricaoMaterial(rs.getString(8));
					to.setNomeLivrosUtilizados(rs.getString(9));
					to.setDisponibilidade(rs.getString(10));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<CursoArtesTO> listarCursoArtes() {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tbArtes";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt(1));
					to.setNome(rs.getString(2));
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setDescricaoMaterial(rs.getString(8));
					to.setNomeLivrosUtilizados(rs.getString(9));
					to.setDisponibilidade(rs.getString(10));
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
	
	public ArrayList<CursoArtesTO> listarCursoArtes(String chave) {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tbArtes where upper(nomeCurso) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt(1));
					to.setNome(rs.getString(2));
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setDescricaoMaterial(rs.getString(8));
					to.setNomeLivrosUtilizados(rs.getString(9));
					to.setDisponibilidade(rs.getString(10));
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
