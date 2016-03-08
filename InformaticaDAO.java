package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import Model.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class InformaticaDAO{

   private Connection con;
   
   public InformaticaDAO(){
      PreparedStatement pst = null;
      ResultSet rs = null;
   }
   
   public void Create(CursoTO to) throws Exception {
     try{
      String sql = "insert into tbInformatica (nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas,valorCurso, descricaoSoftware, numeroDoLaboratorio,disponivel) values (?,?,?,?,?,?,?,?,?)";
      
      con = AcessoBD.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
      ModelArtes artes = new ModelArtes();
      p.setString(1, to.getNomeCurso());
      p.setString(2, to.getDataInicio());
      p.setString(3, to.getDataTermino());
      p.setString(4, to.getHorario());
      p.setInt(5, to.getNumeroVagas());
      p.setString(6, to.getValorCurso());
      p.setString(7, to.getDescricao());
      p.setInt(8, to.getNumeroVagas);
      p.setBoolean(9, disponivel);
      System.out.println("***"+nome + " " + dataIni+ " " +dataFim+" "+ horario + " " +num+ " " +val+" "+DescricaoSoftware+" "+NumeroLaboratorios+" "+disponivel);
    //  p.close();
      
      int rowsInserted = p.executeUpdate();
      if (rowsInserted > 0) {
         JOptionPane.showMessageDialog(null,"O Curso "+nome+" foi inserido com sucesso!");
      } 
      
      AcessoBD.closeConnection(con);
      
      }
      
      catch(SQLException ex){ 
      ex.printStackTrace();
         JOptionPane.showMessageDialog(null,"Não foi possível cadastrar o curso "+nome+" Tente novamente." +ex);
      }
   }

   public void delet(CursoTO to) throws Exception {
      String sql = "delete from tbInformatica where idInfo = ?";
      con = AcessoBD.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
      
      p.setInt(1, to.getIdCurso());
      
      int rowsInserted = p.executeUpdate();
      if (rowsInserted > 0) {
         int response = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o curso?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"O Curso foi excluído com sucesso!");
         } 
      }
      AcessoBD.closeConnection(con);
   }


    public void update(CursoTO to) throws Exception {
      String sql ="update tbInformatica SET idInfo = ?,nomeCurso = ?, dataInicio = ?, dataTermino = ?,horarioPrevisto = ?,numeroDeVagas = ?,valorCurso = ?, descricaoSoftware = ?, numeroDoLaboratorio = ? where idInfo = ?";
      
      con = AcessoBD.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
     
      p.setInt(1, to.getIdCurso());
      p.setString(2, to.getNomeCurso());
      p.setString(3, to.getDataInicio());
      p.setString(4, to.getDataTermino());
      p.setString(5, to.getHorario());
      p.setInt(6, to.getNumeroVagas());
      p.setString(7, to.getValorCurso());
      p.setString(8,to.getDescricao());
      p.setInt(9,to.getNumeroVagas());
      p.setInt(10, to.getIdCurso());
      
     
     
      int rowsInserted = p.executeUpdate();
      if (rowsInserted > 0) {
         JOptionPane.showMessageDialog(null,"O Curso "+nome+" foi alterado com sucesso!");
      } 
      
      AcessoBD.closeConnection(con);
   }
   

   public List<ModelInformatica> listarTodos() throws Exception{
      List<ModelInformatica> listInfo = new ArrayList<ModelInformatica>();
      PreparedStatement p = con.prepareStatement("select * from artes");
      ResultSet rs = p.executeQuery();
      while(rs.next()){
         ModelInformatica info = new ModelInformatica();
         info.setId(rs.getInt("id"));
         info.setNomeCurso(rs.getString("nomeCurso"));
         info.setDataInicio(rs.getString("dataInicio"));
         info.setDataTermino(rs.getString("dataTermino"));
         info.setHorario(rs.getString("horario"));
         info.setNumeroVagas(Integer.parseInt(rs.getString("numeroVagas")));
         info.setValorCurso(Double.parseDouble(rs.getString("valorCurso")));
         info.setNumeroLaboratorios(Integer.parseInt(rs.getString("numeroLaboratorios")));
         listInfo.add(info);
      }
      rs.close();
      p.close();
      return listInfo;
   }

}