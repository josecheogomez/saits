/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.materiaDao;
import its.model.Materia;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josegomez
 */
public class materiaImpDao implements materiaDao{

    @Override
    public List<Materia> listarMateria() {
        //To change body of generated methods, choose Tools | Templates.
        List<Materia> lista=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        String hql="FROM Materia";
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
    public void NuevoMateria(Materia materia) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(materia);
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
    public void actualizarMateria(Materia materia) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(materia);
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
    public void borrarMateria(Materia materia) {
         //To change body of generated methods, choose Tools | Templates.
         Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(materia);
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
    public Materia obtenerMateriaPorCodigo(Session session,Integer codMateria) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         String hql="FROM Materia WHERE matCod=:matCod";
        Query q=session.createQuery(hql);
        q.setParameter("matCod", codMateria);
        return (Materia) q.uniqueResult();
        
    }

    @Override
    public boolean guardarMateria(Session session, Materia materia) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        session.save(materia);
        return true;
    }
    
}
