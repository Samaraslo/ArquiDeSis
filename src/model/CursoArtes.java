package model;

import java.util.ArrayList;

import dao.CursoArtesDAO;
import to.CursoArtesTO;

public class CursoArtes {
	int id;
	String nome, dataInicio, dataTermino, horario, numeroVagas, valor, descricaoMaterial, nomeLivrosUtilizados,disponibilidade;

	public CursoArtes(int id, String nome, String dataInicio, String dataTermino, String horario,
			String numeroVagas, String valor, String descricaoMaterial, String nomeLivrosUtilizados,
			String disponibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horario;
		this.numeroVagas = numeroVagas;
		this.valor = valor;
		this.descricaoMaterial = descricaoMaterial;
		this.nomeLivrosUtilizados = nomeLivrosUtilizados;
		this.disponibilidade = disponibilidade;
	}


	public CursoArtes() {
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

	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}

	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}

	public String getNomeLivrosUtilizados() {
		return nomeLivrosUtilizados;
	}

	public void setNomeLivrosUtilizados(String nomeLivrosUtilizados) {
		this.nomeLivrosUtilizados = nomeLivrosUtilizados;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public CursoArtesTO getTO() {
		CursoArtesTO to = new CursoArtesTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setDescricaoMaterial(descricaoMaterial);
		to.setNomeLivrosUtilizados(nomeLivrosUtilizados);
		to.setDisponibilidade(disponibilidade);
		return to;
	}

	public void incluir() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();

		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setDescricaoMaterial(descricaoMaterial);
		to.setNomeLivrosUtilizados(nomeLivrosUtilizados);
		to.setDisponibilidade(disponibilidade);

		dao.incluir(to);
		this.id = to.getId();
	}

	public void atualizar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		dao.atualizar(to);
	}

	public void excluir() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();

		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {

		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = dao.carregar(id);
		
		id = to.getId();
		nome = to.getNome();		
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		numeroVagas = to.getNumeroVagas();
		valor = to.getValor();
		descricaoMaterial = to.getDescricaoMaterial();
		nomeLivrosUtilizados = to.getNomeLivrosUtilizados();
		disponibilidade = to.getDisponibilidade();


	}
	
	public ArrayList<CursoArtesTO> listarCursoArtes(){
		ArrayList<CursoArtesTO> lista;
		CursoArtesDAO dao = new CursoArtesDAO();
		lista = dao.listarCursoArtes();
		return lista;
	}
	public ArrayList<CursoArtesTO> listarCursoArtes(String chave){
		ArrayList<CursoArtesTO> lista;
		CursoArtesDAO dao = new CursoArtesDAO();
		lista = dao.listarCursoArtes(chave);
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
		CursoArtes other = (CursoArtes) obj;
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
		if (descricaoMaterial == null) {
			if (other.descricaoMaterial != null)
				return false;
		} else if (!descricaoMaterial.equals(other.descricaoMaterial))
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
		if (nomeLivrosUtilizados == null) {
			if (other.nomeLivrosUtilizados != null)
				return false;
		} else if (!nomeLivrosUtilizados.equals(other.nomeLivrosUtilizados))
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
