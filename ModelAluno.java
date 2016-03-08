package DAO;



public class ModelAluno extends ModelCurso{
	private String nome;
   private String endereco;
   private String telefone;
   private String email;
   private String rg;
   private String cpf;

//getters e setters

   public ModelAluno(){
     
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	 public void criar() {
		   AlunoDAO dao = new AlunoDAO();
		   AlunoTO to = new AlunoTO();
		   to.setNome(nome);
		   to.setEndereco(endereco);
		   to.setTelefone(telefone);
		   to.setEmail(email);
		   to.setRg(rg);
		   to.setCpf(cpf);
		   dao.Create(to);
		   }
		   public void atualizar() {
		   AlunoDAO dao = new AlunoDAO();
		   AlunoTO to = new AlunoTO();
		   to.setNome(nome);
		   to.setEndereco(endereco);
		   to.setTelefone(telefone);
		   to.setEmail(email);
		   to.setRg(rg);
		   to.setCpf(cpf);
		   dao.update(to);
		   }
		   public void excluir() {
		   AlunoDAO dao = new AlunoDAO();
		   AlunoTO to = new AlunoTO();
		   to.setCpf(cpf);
		   dao.delet(to);
		   }
  
}//fim da classe Produto