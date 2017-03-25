/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.semestreDao;
import its.model.Semestre;
import its.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josegomez
 */
public class semestreImpDao implements semestreDao{

    @Override
    public List<Semestre> listarSemestre() {
        //To change body of generated methods, choose Tools | Templates.
        List<Semestre> lista=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        String hql="FROM Semestre";
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
    public void NuevoSemestre(Semestre semestre) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(semestre);
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
    public void actualizarSemestre(Semestre semestre) {
        //To change body of generated methods, choose Tools | Templates.
        Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(semestre);
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
    public void borrarSemestre(Semestre semestre) {
         //To change body of generated methods, choose Tools | Templates.
         Session session=null;
        try
        {
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(semestre);
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
    public Semestre obtenerSemestrePorCodigo(Session session,Integer codSemestre) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
         String hql="FROM Semestre WHERE nacCod=:nacCod";
        Query q=session.createQuery(hql);
        q.setParameter("nacCod", codSemestre);
        return (Semestre) q.uniqueResult();
        
    }
    
}
