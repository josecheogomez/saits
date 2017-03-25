/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.unidadDao;
import its.imp.unidadImpDao;
import its.model.Unidad;
import its.util.HibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class unidadBean {
    
    private List<Unidad> listarUnidad;
    private Unidad unidad;
    private Integer codigoUnidad;
    Session session;
    Transaction transaction;
    
    public unidadBean() {
        unidad= new Unidad();
    }
    
    public List<Unidad> getListarUnidad() {
        unidadDao aDao= new unidadImpDao();
        listarUnidad=aDao.listarUnidad();
        return listarUnidad;
    }

    public void setListarUnidad(List<Unidad> listarUnidad) {
        this.listarUnidad = listarUnidad;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Integer getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Integer codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    
    //metodos
    public void prepararNuevoUnidad()
    {
        unidad= new Unidad();
    }
    
    public void nuevoUnidad()
    {
        unidadDao dao= new unidadImpDao();
        dao.NuevoUnidad(unidad);
        unidad= new Unidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarUnidad()
    {
        unidadDao dao= new unidadImpDao();
        dao.actualizarUnidad(unidad);
        unidad= new Unidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarUnidad()
    {
      unidadDao dao=new unidadImpDao();
      dao.borrarUnidad(unidad);
      unidad= new Unidad();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   //metodo para mostrar datos clientes por medio del dialogClientes
    public void agregarDatosUnidad(Integer codUnidad) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            unidadDao cDao = new unidadImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.unidad = cDao.obtenerUnidadPorCodigo(this.session, codUnidad);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Cliente Agregado"));
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
