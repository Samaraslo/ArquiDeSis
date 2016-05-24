package model;

import java.util.ArrayList;

import dao.CursoInfoDAO;
import to.CursoInfoTO;

public class CursoInfo {
	int id;
	String nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, descricaoSoft,disponibilidade;
	
	public CursoInfo(CursoInfoTO to) {
		this.id = to.getId();
		this.nome = to.getNome();
		this.dataInicio = to.getDataInicio();
		this.dataTermino = to.getDataTermino();
		this.horario = to.getHorario();
		this.numeroVagas = to.getNumeroVagas();
		this.valor = to.getValor();
		this.numeroLab = to.getNumeroLab();
		this.descricaoSoft = to.getDescricaoSoft();
		this.disponibilidade = to.getDisponibilidade();
	}
	
	public CursoInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(String numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNumeroLab() {
		return numeroLab;
	}

	public void setNumeroLab(String numeroLab) {
		this.numeroLab = numeroLab;
	}

	public String getDescricaoSoft() {
		return descricaoSoft;
	}

	public void setDescricaoSoft(String descricaoSoft) {
		this.descricaoSoft = descricaoSoft;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
	public CursoInfoTO getTO() {
		CursoInfoTO to = new CursoInfoTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setNumeroLab(numeroLab);
		to.setDescricaoSoft(descricaoSoft);
		to.setDisponibilidade(disponibilidade);
		return to;
	}

	public void incluir() {
		CursoInfoDAO dao = new CursoInfoDAO();
		CursoInfoTO to = new CursoInfoTO();
		
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setNumeroLab(numeroLab);
		to.setDescricaoSoft(descricaoSoft);
		to.setDisponibilidade(disponibilidade);

		dao.incluir(to);
		this.id = to.getId();
	}

	public void atualizar() {
		CursoInfoDAO dao = new CursoInfoDAO();
		CursoInfoTO to = new CursoInfoTO();
		dao.atualizar(to);
	}

	public void excluir() {
		CursoInfoDAO dao = new CursoInfoDAO();
		CursoInfoTO to = new CursoInfoTO();

		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		CursoInfoDAO dao = new CursoInfoDAO();
		CursoInfoTO to = dao.carregar(id);

		nome = to.getNome();		
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		numeroVagas = to.getNumeroVagas();
		valor = to.getValor();
		numeroLab = to.getNumeroLab();
		descricaoSoft = to.getDescricaoSoft();
		disponibilidade = to.getDisponibilidade();


	}
	
	public ArrayList<CursoInfoTO> listarCursoInfo(){
		ArrayList<CursoInfoTO> lista;
		CursoInfoDAO dao = new CursoInfoDAO();
		lista = dao.listarCursoInfo();
		return lista;
	}
	
	public ArrayList<CursoInfoTO> listarCursoInfo(String chave){
		ArrayList<CursoInfoTO> lista;
		CursoInfoDAO dao = new CursoInfoDAO();
		lista = dao.listarCursoInfo(chave);
		return lista;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoInfo other = (CursoInfo) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (descricaoSoft == null) {
			if (other.descricaoSoft != null)
				return false;
		} else if (!descricaoSoft.equals(other.descricaoSoft))
			return false;
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroLab == null) {
			if (other.numeroLab != null)
				return false;
		} else if (!numeroLab.equals(other.numeroLab))
			return false;
		if (numeroVagas == null) {
			if (other.numeroVagas != null)
				return false;
		} else if (!numeroVagas.equals(other.numeroVagas))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
}
