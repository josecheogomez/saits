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
import its.dao.entidadDao;
import its.model.Entidad;
import its.util.HibernateUtil;

/**
 *
 * @author josegomez
 */
public class entidadImpDao implements entidadDao {

    @Override
    public List<Entidad> listarEntidad() {
        List<Entidad> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Entidad";
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
    public void nuevoEntidad(Entidad entidad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entidad);
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
    public void actualizarEntidad(Entidad entidad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entidad);
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
    public Entidad obtenerEntidadPorCodigo(Session session, Integer codEntidad) throws Exception {
        String hql="FROM Entidad WHERE actCod=:actCod";
        Query q=session.createQuery(hql);
        q.setParameter("actCod", codEntidad);
        return (Entidad) q.uniqueResult();
        
    }

    @Override
    public void borrarEntidad(Entidad entidad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entidad);
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
