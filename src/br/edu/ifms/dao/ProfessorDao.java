/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.dao;

import br.edu.ifms.model.ProfessorModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;


public class ProfessorDao {
    
    public void salvarBD(ProfessorModel professor) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(professor);
        transaction.commit();
        session.close();
    }
    
    public List<ProfessorModel> buscarTodosBD() throws SQLException{
        List<ProfessorModel> lista = new LinkedList<ProfessorModel>();
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/projetofinal", "root", "");
            String sql = "select * from professores;";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                ProfessorModel professor = new ProfessorModel();
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setSexo(rs.getString("sexo"));
                professor.setIdade(rs.getInt("idade"));
                professor.setSiape(rs.getLong("siape"));
                lista.add(professor);
            }
            return lista;
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        } finally{
            conexao.close();
        }
        return null;
    }
    
    public ProfessorModel buscarPorSiapeBD(long siape) throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/projetofinal", "root", "");
            String sql = "select * from professores where siape = "+siape+";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            ProfessorModel professor = new ProfessorModel();
            professor.setNome(rs.getString("nome"));
            professor.setCpf(rs.getString("cpf"));
            professor.setSexo(rs.getString("sexo"));
            professor.setIdade(rs.getInt("idade"));
            professor.setSiape(rs.getLong("siape"));
            return professor;
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        } finally{
            conexao.close();
        }
        return null;
    }
    
      public void alterarBD(ProfessorModel professor) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(professor);
        transaction.commit();
        session.close();
    }
    
    public void removerBD(long siape) throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/projetofinal", "root", "");
            String sql = "delete from professores where siape = "+siape+";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        } finally{
            conexao.close();
        }
    }
}