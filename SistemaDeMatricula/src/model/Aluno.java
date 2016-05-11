package model;

import java.util.ArrayList;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {
	private int id;
	String nome, endereco, telefone, cpf, rg, email, login ,senha;
	
	public Aluno(int id, String nome, String endereco, String telefone, String cpf, String rg, String email, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}
	
	public Aluno(){}
	/*public Aluno(AlunoTO alunoTO){
				
		this.nome = alunoTO.getNome();
		this.endereco = alunoTO.getEndereco();
		this.telefone = alunoTO.getTelefone();
		this.cpf = alunoTO.getCpf();
		this.rg = alunoTO.getRg();
		this.email = alunoTO.getEmail();
		this.login = alunoTO.getLogin();
		this.senha = alunoTO.getSenha();		
		
		
	}*/
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	
	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);
		return to;
	}

	public void incluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setEmail(email);
		to.setLogin(login);
		to.setSenha(senha);

		dao.incluir(to);
	}

	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();

		to.setCpf(cpf);
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(cpf);

		nome = to.getNome();
		endereco = to.getEndereco();
		telefone = to.getTelefone();
		cpf = to.getCpf();
		rg = to.getRg();
		email = to.getEmail();
		login = to.getLogin();
		senha = to.getSenha();

	}
	
	public ArrayList<AlunoTO> listarClientes(){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarClientes();
		return lista;
	}
	public ArrayList<AlunoTO> listarClientes(String chave){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarClientes(chave);
		return lista;
	}


}
