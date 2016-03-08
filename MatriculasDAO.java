package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import Model.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;



public class MatriculasDAO{

   private Connection con;
   
   public MatriculasDAO(){
   
   super(); 
    
      PreparedStatement pst = null;
      ResultSet rs = null;
   }
   
   public void Create(String nomeAluno, String dataMatricula,String valor,String statusPagamento, String statusMatricula, String cursosArtes, String cursosInfo) throws Exception {
      try{
         String sql = "insert into tbMatricula (nomeAluno, dataMatricula, valor, statusPagamento, statusMatricula,cursosArtes,cursosInformatica) values (?,?,?,?,?,?,?)";
      
         con = ConnectionFactory.conector(); 
         PreparedStatement p = con.prepareStatement(sql);
         p.setString(1, nomeAluno);
         p.setString(2, dataMatricula);
         p.setString(3, valor);
         p.setString(4, statusPagamento);
         p.setString(5, statusMatricula);
         p.setString(6, cursosArtes);
         p.setString(7, cursosInfo);
      
      
         int rowsInserted = p.executeUpdate();
         if (rowsInserted > 0) {
            
         } 
         ConnectionFactory.closeConnection(con);
      
      }
      catch(SQLException ex){ 
      
        ex.printStackTrace();
        // JOptionPane.showMessageDialog(null,"Não foi possível cadastrar o Aluno "+nome+" pois ele já existe no nosso banco de dados.");
      }
   }

   public void update(String statusPagamento, String statusMatricula, String cpf) throws Exception {
      String sql ="update tbMatricula SET statusPagamento = ?,statusMatricula = ? where nomeAluno=?";
      
      con = ConnectionFactory.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
     
      p.setString(1, statusPagamento);
      p.setString(2, statusMatricula);
      p.setString(3, cpf);
      
      //System.out.println("***"+nome + " " + endereco+ " " +telefone+" "+ email + " " +rg+ " " +cpf);
     
     
      int rowsInserted = p.executeUpdate();
           
      ConnectionFactory.closeConnection(con);
   }
   

   public void delet(String cpf) throws Exception {
      String sql = "delete from tbAlunos where cpf = ?";
      con = ConnectionFactory.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
      
      p.setString(1, cpf);
      
      int rowsInserted = p.executeUpdate();
      if (rowsInserted > 0) {
         int response = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o aluno?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"O Curso foi excluído com sucesso!");
         } 
      }
      ConnectionFactory.closeConnection(con);
   }

}