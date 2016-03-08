package DAO;


public class ModelCurso{
   private int idCurso;
   private String nomeCurso;
   private String dataInicio;
   private String dataTermino;
   private String horario;
   private int numeroVagas;
   private double valorCurso;

//getters e setters
   
   public ModelCurso(){
   
   }

   public void setId(int id){
      this.idCurso = id;
   }

   public int getId(){
      return this.idCurso;
   }

   public void setNomeCurso(String nome){
      this.nomeCurso = nome;
   }

   public String getNomeCurso(){
      return this.nomeCurso;
   }

   public void setDataInicio(String  dataIni ){
      this.dataInicio =  dataIni ;
   }

   public String getDataInicio(){
      return this.dataInicio;
   }
   
   public void setDataTermino(String  dataFim ){
      this.dataTermino =  dataFim ;
   }

   public String getDataTermino(){
      return this.dataTermino;
   }
   
    public void setHorario(String  horario ){
      this.horario =  horario ;
   }

   public String getHorario(){
      return this.horario;
   }
   
    public void setNumeroVagas(int  numero ){
      this.numeroVagas =  numero ;
   }

   public int getNumeroVagas(){
      return this.numeroVagas;
   }
   
    public void setValorCurso(double  valorCurso ){
      this.valorCurso =  valorCurso ;
   }

   public double getValorCurso(){
      return this.valorCurso;
   }
   
   public void criar() {
	   CursoDAO dao = new CursoDAO();
	   CursoTO to = new CursoTO();
	   to.setId(idCurso);
	   to.setNome(nomeCurso);
	   to.setDataInicio(dataInicio);
	   to.setDataTermino(dataTermino);
	   to.setHorario(horario);
	   to.setNumeroVagas(numeroVagas);
	   to.setValorCurso(valorCurso);
	   dao.Create(to);
	   }
	   public void atualizar() {
	   CursoDAO dao = new CursoDAO();
	   CursoTO to = new CursoTO();
	   to.setId(idCurso);
	   to.setNome(nomeCurso);
	   to.setDataInicio(dataInicio);
	   to.setDataTermino(dataTermino);
	   to.setHorario(horario);
	   to.setNumeroVagas(numeroVagas);
	   to.setValorCurso(valorCurso);
	   dao.update(to);
	   }
	   public void excluir() {
	   CursoDAO dao = new CursoDAO();
	   CursoTO to = new CursoTO();
	   to.setId(idCurso);
	   dao.delet(to);
	   }
  
   

}//fim da classe Produto