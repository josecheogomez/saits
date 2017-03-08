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
import its.dao.actividadDao;
import its.model.Actividad;
import its.util.HibernateUtil;

/**
 *
 * @author josegomez
 */
public class actividadImpDao implements actividadDao {

    @Override
    public List<Actividad> listarActividades() {
        List<Actividad> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Actividad";
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
    public void nuevoActividad(Actividad actividad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(actividad);
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
    public void actualizarActividad(Actividad actividad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(actividad);
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
    public Actividad obtenerActividadPorCodigo(Session session, Integer codActividad) throws Exception {
        String hql="FROM Actividad WHERE actCod=:actCod";
        Query q=session.createQuery(hql);
        q.setParameter("actCod", codActividad);
        return (Actividad) q.uniqueResult();
        
    }

    @Override
    public void borrarActividad(Actividad actividad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(actividad);
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
