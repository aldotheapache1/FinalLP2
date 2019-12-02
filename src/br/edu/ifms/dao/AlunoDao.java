/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.dao;

import br.edu.ifms.model.AlunoModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;


public class AlunoDao {
    
    public void salvarBD(AlunoModel aluno) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(aluno);
        transaction.commit();
        session.close();
    }
    
    public List<AlunoModel> buscarTodosBD() throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from AlunoModel");
        List<AlunoModel> lista = query.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public AlunoModel buscarAlunoPorRaBD(long ra) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from AlunoModel where ra = :ra");
        query.setParameter("ra", ra);
        AlunoModel aluno = (AlunoModel) query.list().get(0);
        transaction.commit();
        session.close();
        return aluno;
    }
    
    public void removerBD(long ra) throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/projetofinal", "root", "");
            String sql = "delete from alunos where ra = "+ra+";";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        } finally{
            conexao.close();
        }
    }
    public void alterarBD(AlunoModel aluno) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(aluno);
        transaction.commit();
        session.close();
    }
}