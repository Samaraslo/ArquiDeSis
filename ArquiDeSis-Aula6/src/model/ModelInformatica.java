package model;

import dao.InformaticaDAO;
import to.InformaticaTO;

public class ModelInformatica {
   private String descricaoSoftware;
   private String numeroLaboratorios;
   private String idCurso;
   private String nomeCurso;
   private String dataInicio;
   private String dataTermino;
   private String horario;
   private String numeroVagas;
   private String valorCurso;
   private String descricao;
   private String livros;
   private String registroSoft;
   private String NumeroLab;
   private String disponibilidade;
   
   public ModelInformatica (InformaticaTO informaticaTO){

		this.idCurso = informaticaTO.getIdCurso();
		this.nomeCurso = informaticaTO.getNomeCurso();
		this.dataInicio =  informaticaTO.getDataInicio(); 
		this.dataTermino = informaticaTO.getDataTermino();
		this.horario = informaticaTO.getHorario();
		this.numeroVagas =  informaticaTO.getNumeroVagas();
		this.valorCurso = informaticaTO.getValorCurso();
		this.numeroLaboratorios = informaticaTO.getNumeroLab();
		this.registroSoft= informaticaTO.getRegistroSoft();
		this.disponibilidade= informaticaTO.getDisponibilidade();

	}
	   
	   
	public String getDescricaoSoftware() {
		return descricaoSoftware;
	}
	public void setDescricaoSoftware(String descricaoSoftware) {
		this.descricaoSoftware = descricaoSoftware;
	}
	public String getNumeroLaboratorios() {
		return numeroLaboratorios;
	}
	public void setNumeroLaboratorios(String numeroLaboratorios) {
		this.numeroLaboratorios = numeroLaboratorios;
	}
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
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
	public String getValorCurso() {
		return valorCurso;
	}
	public void setValorCurso(String valorCurso) {
		this.valorCurso = valorCurso;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLivros() {
		return livros;
	}
	public void setLivros(String livros) {
		this.livros = livros;
	}
	public String getRegistroSoft() {
		return registroSoft;
	}
	public void setRegistroSoft(String registroSoft) {
		this.registroSoft = registroSoft;
	}
	public String getNumeroLab() {
		return NumeroLab;
	}
	public void setNumeroLab(String numeroLab) {
		NumeroLab = numeroLab;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	
	
	public void cadastrar() throws Exception {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();

		to.setIdCurso(idCurso);
		to.setNomeCurso(nomeCurso);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setNumeroLab(NumeroLab);
		to.setRegistroSoft(registroSoft);
		to.setDisponibilidade(disponibilidade);
		
		dao.Create(to);
	}

	/*public void alterar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();

		to.setCodigo(codigo);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setNumeroVagas(numeroVagas);
		to.setValor(valor);
		to.setNumeroLab(numeroLab);
		to.setRegistroSoft(registroSoft);
		to.setDisponibilidade(disponibilidade);

		dao.alterar(to);
	}

	public void deletar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO to = new InformaticaTO();

		to.setCodigo(codigo);
		dao.deletar(to);
	}

	public void carregar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO armazenaCodigo = new InformaticaTO();
		armazenaCodigo.setCodigo(codigo);
		InformaticaTO to = dao.consultar(armazenaCodigo);

		codigo = to.getCodigo();
		nome = to.getNome();
		dataInicio =  to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		numeroVagas =  to.getNumeroVagas();
		valor = to.getValor();
		numeroLab = to.getNumeroLab();
		registroSoft = to.getRegistroSoft();
		disponibilidade= to.getDisponibilidade();
		
	}

	
	public InformaticaTO consultar() {
		InformaticaDAO dao = new InformaticaDAO();
		InformaticaTO armazenaCodigo = new InformaticaTO();
		armazenaCodigo.setCodigo(codigo);
		InformaticaTO TO = dao.consultar(armazenaCodigo);

		return TO;
	}*/
}//fim da classe Produto