/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import its.dao.carreraDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.mallaDao;
import its.imp.carreraImpDao;
import its.imp.mallaImpDao;
import its.model.Carrera;
import its.model.Malla;
import its.util.HibernateUtil;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class mallaBean {
    
    private List<Malla> listarMalla;
    private Malla malla;
    private Integer codigoMalla;
    private Integer codigoCarrera;
    Session session;
    Transaction transaction;
    private Carrera carrera;
    
    public mallaBean() {
        malla= new Malla();
        carrera=new Carrera();
    }
    
    public List<Malla> getListarMalla() {
        mallaDao aDao= new mallaImpDao();
        listarMalla=aDao.listarMalla();
        return listarMalla;
    }

    public void setListarMalla(List<Malla> listarMalla) {
        this.listarMalla = listarMalla;
    }

    public Malla getMalla() {
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public Integer getCodigoMalla() {
        return codigoMalla;
    }

    public void setCodigoMalla(Integer codigoMalla) {
        this.codigoMalla = codigoMalla;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(Integer codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    
    //metodos
    public void prepararNuevoMalla()
    {
        malla= new Malla();
        carrera= new Carrera();
    }
    
    public void nuevoMalla()
    {
        mallaDao dao= new mallaImpDao();
        dao.NuevoMalla(malla);
        malla= new Malla();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarMalla()
    {
        mallaDao dao= new mallaImpDao();
        dao.actualizarMalla(malla);
        malla= new Malla();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarMalla()
    {
      mallaDao dao=new mallaImpDao();
      dao.borrarMalla(malla);
      malla= new Malla();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   public void agregarDatosCarrera(Integer codCarrera) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            carreraDao cDao = new carreraImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.carrera = cDao.obtenerCarreraPorCodigo(this.session, codCarrera);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Agregado"));
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
     public void agregarDatosCarrera2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoCarrera == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            carreraDao cDao = new carreraImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.carrera = cDao.obtenerCarreraPorCodigo(this.session, codigoCarrera);
            if (this.carrera != null) {
                this.codigoCarrera = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Unidad Agregado"));
            } else {
                this.codigoCarrera = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del Unidad No encontrado"));
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
