/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.semestreDao;
import its.imp.semestreImpDao;
import its.model.Semestre;
import its.util.HibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class semestreBean {
    
    private List<Semestre> listarSemestre;
    private Semestre semestre;
    private Integer codigoSemestre;
    
    /*variables hibernate*/
    private Session session;
    private Transaction transaction;
    
    public semestreBean() {
        semestre= new Semestre();
    }
    
    public List<Semestre> getListarSemestre() {
        semestreDao aDao= new semestreImpDao();
        listarSemestre=aDao.listarSemestre();
        return listarSemestre;
    }

    public void setListarSemestre(List<Semestre> listarSemestre) {
        this.listarSemestre = listarSemestre;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
    
    //metodos
    public void prepararNuevoSemestre()
    {
        semestre= new Semestre();
    }
    
    public void nuevoSemestre()
    {
        semestreDao dao= new semestreImpDao();
        dao.NuevoSemestre(semestre);
        semestre= new Semestre();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarSemestre()
    {
        semestreDao dao= new semestreImpDao();
        dao.actualizarSemestre(semestre);
        semestre= new Semestre();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarSemestre()
    {
      semestreDao dao=new semestreImpDao();
      dao.borrarSemestre(semestre);
      semestre= new Semestre();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }

    public Integer getCodigoSemestre() {
        return codigoSemestre;
    }

    public void setCodigoSemestre(Integer codigoSemestre) {
        this.codigoSemestre = codigoSemestre;
    }
    
    //metodo para mostrar datos Semestre por medio del dialogSemestre
    public void agregarDatosSemestre(Integer codSemestre) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            semestreDao cDao = new semestreImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.semestre = cDao.obtenerSemestrePorCodigo(this.session, codSemestre);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Semestre Agregado"));
        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println("Error" + e.getMessage());
                transaction.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
    //metodo para mostrar datos Semestre por medio del codigo
    public void agregarDatosSemestre2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoSemestre == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            semestreDao cDao = new semestreImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.semestre = cDao.obtenerSemestrePorCodigo(this.session, codigoSemestre);
            if (this.semestre != null) {
                this.codigoSemestre = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Semestre Agregado"));
            } else {
                this.codigoSemestre = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del Semestre No encontrado"));
            }
            this.transaction.commit();
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Datos del Cliente Agregado"));
        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println("Error" + e.getMessage());
                transaction.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
   
}
