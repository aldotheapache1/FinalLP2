/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.dao;

import br.edu.ifms.model.CursoModel;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author Gian
 */
public class CursoDao {
    public void salvarBD(CursoModel curso) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(curso);
        transaction.commit();
        session.close();
    }
    
    public void alterarBD(CursoModel curso) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(curso);
        transaction.commit();
        session.close();
    }
    
    public List<CursoModel> buscarTodosBD() throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CursoModel");
        List<CursoModel> lista = query.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public CursoModel buscarCursoPorIdBD(long id) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CursoModel where id = :id");
        query.setParameter("id", id);
        CursoModel area = (CursoModel) query.list().get(0);
        transaction.commit();
        session.close();
        return area;
    }
    
    public void removerBD(CursoModel curso) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(curso);
        transaction.commit();
        session.close();
    }
}
