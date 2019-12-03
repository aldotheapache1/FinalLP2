/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.dao;

import br.edu.ifms.model.AlunoModel;
import br.edu.ifms.model.ProfessorModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
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
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ProfessorModel");
        List<ProfessorModel> lista = query.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public ProfessorModel buscarPorSiapeBD(long siape) throws SQLException{
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ProfessorModel where siape = :siape");
        query.setParameter("siape", siape);
        ProfessorModel professor = (ProfessorModel) query.list().get(0);
        transaction.commit();
        session.close();
        return professor;
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