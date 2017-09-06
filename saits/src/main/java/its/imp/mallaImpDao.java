/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.mallaDao;
import its.model.Malla;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author José Gómez
 */
public class mallaImpDao implements mallaDao{

    @Override
    public List<Malla> listarMalla() {
        //objeto tipo list que instancia la clase malla
        List<Malla> lista=null;
        //abrimos la session hibernate
        Session session=HibernateUtil.getSessionFactory().openSession();
        //declaramos la transaccion
        Transaction t=session.beginTransaction();
        String hql="FROM Malla";
        try
        {
            lista=session.createQuery(hql).list();
            t.commit();
            session.close();
        }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }
        return lista;
    }

    @Override
    public void NuevoMalla(Malla malla) {
        
        Session session=null;
        try
        {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(malla);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            //si hay un error realiza el rollback
        session.getTransaction().rollback();
        System.out.println("Error"+e);
        }
        finally
        {
            if(session!=null)
            {
                //cerramos la session
            session.close();
            }
        }
    }

    @Override
    public void actualizarMalla(Malla malla) {
        Session session=null;
        try
        {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(malla);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("Error"+e);
        }
        finally
        {
            if(session!=null)
            {
            session.close();
            }
        }
    }

    @Override
    public void borrarMalla(Malla malla) {
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(malla);
        session.getTransaction().commit();
        }
        catch(Exception e)
        {
        session.getTransaction().rollback();
        System.out.println("Error"+e);
        }
        finally
        {
        if (session!=null)
        {
        session.close();
        }
        }
    }

    @Override
    public Malla obtenerMallaPorCodigo(Session session, Integer codMalla) throws Exception {
        String hql="FROM Malla WHERE malCod=:malCod";
        Query q=session.createQuery(hql);
        q.setParameter("malCod", codMalla);
        return (Malla) q.uniqueResult();
    }

    @Override
    public Malla obtenerUltimoRegistro(Session session) throws Exception {
    String hql="FROM Malla ORDER BY malCod DESC";
    Query q= session.createQuery(hql).setMaxResults(1);
    return (Malla) q.uniqueResult();
    }

    @Override
    public long obtenerTotalRegistro(Session session) {
    String hql="SELECT COUNT(*) FROM Malla";
    Query q=session.createQuery(hql);
    return (Long) q.uniqueResult();
    }
    
}
