
package br.edu.ifms.dao;


import br.edu.ifms.model.AreaModel;
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


public class AreaDao {
    public void salvarBD(AreaModel area) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(area);
        transaction.commit();
        session.close();
    }
    
    public void alterarBD(AreaModel area) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(area);
        transaction.commit();
        session.close();
    }
    
    public List<AreaModel> buscarTodosBD() throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from AreaModel");
        List<AreaModel> lista = query.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public AreaModel buscarAreaPorIdBD(long id) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from AreaModel where id = :id");
        query.setParameter("id", id);
        AreaModel area = (AreaModel) query.list().get(0);
        transaction.commit();
        session.close();
        return area;
    }
    
    public void removerBD(AreaModel area) throws SQLException{
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(area);
        transaction.commit();
        session.close();
    }
}
