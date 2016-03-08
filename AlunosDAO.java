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


public class AlunosDAO{

   private Connection con;
   
   public AlunosDAO(){
      PreparedStatement pst = null;
      ResultSet rs = null;
   }
   
   public void Create(AlunoTO to) throws Exception {
      try{
         String sql = "insert into tbAlunos (nomeAluno, endereco, telefone, email, rg,cpf) values (?,?,?,?,?,?)";
      
         con = ConnectionFactory.conector(); 
         PreparedStatement p = con.prepareStatement(sql);
         ModelArtes artes = new ModelArtes();
         p.setString(1, to.getNome());
         p.setString(2, to.getEndereco());
         p.setString(3, to.getTelefone());
         p.setString(4, to.getEmail());
         p.setString(5, to.getRg());
         p.setString(6, to.getCpf());
      
      
         int rowsInserted = p.executeUpdate();
         if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null,"O Aluno "+nome+" foi inserido com sucesso!");
         } 
         ConnectionFactory.closeConnection(con);
      
      }
      catch(SQLException ex){ 
      
         JOptionPane.showMessageDialog(null,"Não foi possível cadastrar o Aluno "+nome+" pois ele já existe no nosso banco de dados.");
      }
   }

   public void update(AlunoTO to) throws Exception {
      String sql ="update tbAlunos SET idAluno = ?,nomeAluno = ?, endereco = ?, telefone = ?,email = ?,rg = ?, cpf=? where cpf=?";
      
      con = ConnectionFactory.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
     
      p.setString(1, to.getCpf());
      p.setString(2, to.getNome());
      p.setString(3, to.getEndereco());
      p.setString(4, to.getTelefone());
      p.setString(5, to.getEmail());
      p.setString(6, to.getRg());
      p.setString(7, to.getCpf());
      p.setString(8, to.getCpf());
     
     
      int rowsInserted = p.executeUpdate();
      if (rowsInserted > 0) {
         JOptionPane.showMessageDialog(null,"O Aluno "+nome+" foi alterado com sucesso!");
      } 
      
      ConnectionFactory.closeConnection(con);
   }
   

   public void delet(AlunoTO to) throws Exception {
      String sql = "delete from tbAlunos where cpf = ?";
      con = ConnectionFactory.conector(); 
      PreparedStatement p = con.prepareStatement(sql);
      
      p.setString(1, to.getCpf());
      
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

}//fim da classe ProdutoDAO