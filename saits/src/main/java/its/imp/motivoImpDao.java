/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import its.dao.motivoDao;
import its.model.Motivo;
import its.util.HibernateUtil;

/**
 *
 * @author josegomez
 */
public class motivoImpDao implements motivoDao {

    @Override
    public List<Motivo> listarMotivo() {
        List<Motivo> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Motivo";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return lista;
    }

    @Override
    public void nuevoMotivo(Motivo motivo) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(motivo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void actualizarMotivo(Motivo motivo) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(motivo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Motivo obtenerMotivoPorCodigo(Session session, Integer codMotivo) throws Exception {
        String hql="FROM Motivo WHERE actCod=:actCod";
        Query q=session.createQuery(hql);
        q.setParameter("actCod", codMotivo);
        return (Motivo) q.uniqueResult();
        
    }

    @Override
    public void borrarMotivo(Motivo motivo) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(motivo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
