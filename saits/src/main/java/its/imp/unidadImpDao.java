/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.unidadDao;
import its.model.Unidad;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josegomez
 */
public class unidadImpDao implements unidadDao{

    @Override
    public List<Unidad> listarUnidad() {
        //To change body of generated methods, choose Tools | Templates.
        List<Unidad> lista=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        String hql="FROM Unidad";
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
    public void NuevoUnidad(Unidad unidad) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unidad);
        //se concluye la transaccion de registro
        session.getTransaction().commit();
        }
        catch(Exception e)
        {
            //se hace un rollback en caso de que hayga error 
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
    public void actualizarUnidad(Unidad unidad) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unidad);
        //se concluye la transaccion de registro
        session.getTransaction().commit();
        }
        catch(Exception e)
        {
            //se hace un rollback en caso de que hayga error 
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
    public void borrarUnidad(Unidad unidad) {
         //To change body of generated methods, choose Tools | Templates.
         Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unidad);
        //se concluye la transaccion de registro
        session.getTransaction().commit();
        }
        catch(Exception e)
        {
            //se hace un rollback en caso de que hayga error 
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
    public Unidad obtenerUnidadPorCodigo(Session session,Integer codUnidad) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         String hql="FROM Unidad WHERE uniCod=:uniCod";
        Query q=session.createQuery(hql);
        q.setParameter("uniCod", codUnidad);
        return (Unidad) q.uniqueResult();
        
    }
    
}
