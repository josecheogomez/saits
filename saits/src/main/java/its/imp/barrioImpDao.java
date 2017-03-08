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
import its.dao.barrioDao;
import its.model.Barrio;
import its.util.HibernateUtil;

/**
 *
 * @author josegomez
 */
public class barrioImpDao implements barrioDao {

    @Override
    public List<Barrio> listarBarrio() {
        List<Barrio> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Barrio";
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
    public void nuevoBarrio(Barrio barrio) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(barrio);
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
    public void actualizarBarrio(Barrio barrio) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(barrio);
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
    public Barrio obtenerBarrioPorCodigo(Session session, Integer codBarrio) throws Exception {
        String hql="FROM Barrio WHERE barCod=:barCod";
        Query q=session.createQuery(hql);
        q.setParameter("barCod", codBarrio);
        return (Barrio) q.uniqueResult();
        
    }

    @Override
    public void borrarBarrio(Barrio barrio) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(barrio);
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
