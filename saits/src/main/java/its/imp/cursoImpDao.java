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
import its.dao.cursoDao;
import its.model.Curso;
import its.util.HibernateUtil;

/**
 *
 * @author josegomez
 */
public class cursoImpDao implements cursoDao {

    @Override
    public List<Curso> listarCurso() {
        List<Curso> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Curso";
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
    public void nuevoCurso(Curso curso) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(curso);
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
    public void actualizarCurso(Curso curso) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(curso);
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
    public Curso obtenerCursoPorCodigo(Session session, Integer codCurso) throws Exception {
        String hql="FROM Curso WHERE actCod=:actCod";
        Query q=session.createQuery(hql);
        q.setParameter("actCod", codCurso);
        return (Curso) q.uniqueResult();
        
    }

    @Override
    public void borrarCurso(Curso curso) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(curso);
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
