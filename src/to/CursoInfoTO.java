package to;

public class CursoInfoTO {  

	int id;
	String nome, dataInicio, dataTermino, horario, numeroVagas, valor, numeroLab, descricaoSoft,disponibilidade;
	
	
	public CursoInfoTO() {
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoInfoTO other = (CursoInfoTO) obj;
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
	


}
