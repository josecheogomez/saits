/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.nacionalidadDao;
import its.model.Nacionalidad;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josegomez
 */
public class nacionalidadImpDao implements nacionalidadDao{

    @Override
    public List<Nacionalidad> listarNacionalidad() {
        //To change body of generated methods, choose Tools | Templates.
        List<Nacionalidad> lista=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        String hql="FROM Nacionalidad";
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
    public void NuevoNacionalidad(Nacionalidad nacionalidad) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(nacionalidad);
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
    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(nacionalidad);
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
    public void borrarNacionalidad(Nacionalidad nacionalidad) {
         //To change body of generated methods, choose Tools | Templates.
         Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(nacionalidad);
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
    public Nacionalidad obtenerNacionalidadPorCodigo(Session session,Integer codNacionalidad) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         String hql="FROM Nacionalidad WHERE nacCod=:nacCod";
        Query q=session.createQuery(hql);
        q.setParameter("nacCod", codNacionalidad);
        return (Nacionalidad) q.uniqueResult();
        
    }
    
}
