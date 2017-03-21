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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class unidadBean {
    
    private List<Unidad> listarUnidad;
    private Unidad unidad;
    
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
   
}
