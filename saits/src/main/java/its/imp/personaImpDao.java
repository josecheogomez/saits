/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.personaDao;
import its.model.Persona;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josegomez
 */
public class personaImpDao implements personaDao{

    @Override
    public List<Persona> listarPersona() {
        //To change body of generated methods, choose Tools | Templates.
        List<Persona> lista=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        String hql="FROM Persona";
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
    public void NuevoPersona(Persona persona) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(persona);
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
    public void actualizarPersona(Persona persona) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(persona);
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
    public void borrarPersona(Persona persona) {
         //To change body of generated methods, choose Tools | Templates.
         Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(persona);
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
    public Persona obtenerPersonaPorCodigo(Session session,Integer codPersona) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         String hql="FROM Persona WHERE perCod=:perCod";
        Query q=session.createQuery(hql);
        q.setParameter("perCod", codPersona);
        return (Persona) q.uniqueResult();
        
    }
    
}
