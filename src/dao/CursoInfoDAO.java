package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.CursoInfoTO;
import factory.ConnectionFactory;

public class CursoInfoDAO {
	public void incluir(CursoInfoTO to) {
		String sqlInsert = "INSERT INTO tbInformatica(nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas, valorCurso, descricaoSoftware, numeroDoLaboratorio, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getDataInicio());
			stm.setString(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setString(5, to.getNumeroVagas());
			stm.setString(6, to.getValor());
			stm.setString(7, to.getDescricaoSoft());
			stm.setString(8, to.getNumeroLab());
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
	
	public void atualizar(CursoInfoTO to) {
		String sqlUpdate = "UPDATE tbInformatica SET nomeCurso=?, dataInicio=?, dataTermino=?, horarioPrevisto=?, numeroDeVagas=?, valorCurso=?, descricaoSoftware=?, numeroDoLaboratorio=?, disponivel=? WHERE idInfo =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getDataInicio());
			stm.setString(3, to.getDataTermino());
			stm.setString(4, to.getHorario());
			stm.setString(5, to.getNumeroVagas());
			stm.setString(6, to.getValor());
			stm.setString(7, to.getDescricaoSoft());
			stm.setString(8, to.getNumeroLab());
			stm.setString(9, to.getDisponibilidade());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(CursoInfoTO to) {
		String sqlDelete = "DELETE FROM tbInformatica WHERE idInfo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CursoInfoTO carregar(int id) {
		CursoInfoTO to = new CursoInfoTO();
		to.setId(id);
		String sqlSelect = "SELECT nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas, valorCurso, descricaoSoftware, numeroDoLaboratorio, disponivel FROM tbInformatica WHERE idInfo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getString("numeroDeVagas"));
					to.setValor(rs.getString("valorCurso"));
					to.setDescricaoSoft(rs.getString("descricaoSoftware"));
					to.setNumeroLab(rs.getString("numeroDoLaboratorio"));
					to.setDisponibilidade(rs.getString("disponivel"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<CursoInfoTO> listarCursoInfo() {
		CursoInfoTO to;
		ArrayList<CursoInfoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tbInformatica";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInfoTO();
					to.setId(rs.getInt(1));
					to.setNome(rs.getString(2));
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setDescricaoSoft(rs.getString(8));
					to.setNumeroLab(rs.getString(9));
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
	
	public ArrayList<CursoInfoTO> listarCursoInfo(String chave) {
		CursoInfoTO to;
		ArrayList<CursoInfoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tbInformatica where upper(nomeCurso) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInfoTO();
					to.setId(rs.getInt(1));
					to.setNome(rs.getString(2));
					to.setDataInicio(rs.getString(3));
					to.setDataTermino(rs.getString(4));
					to.setHorario(rs.getString(5));
					to.setNumeroVagas(rs.getString(6));
					to.setValor(rs.getString(7));
					to.setDescricaoSoft(rs.getString(8));
					to.setNumeroLab(rs.getString(9));
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
