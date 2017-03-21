/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.nacionalidadDao;
import its.imp.nacionalidadImpDao;
import its.model.Nacionalidad;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class nacionalidadBean {
    
    private List<Nacionalidad> listarNacionalidad;
    private Nacionalidad nacionalidad;
    
    public nacionalidadBean() {
        nacionalidad= new Nacionalidad();
    }
    
    public List<Nacionalidad> getListarNacionalidad() {
        nacionalidadDao aDao= new nacionalidadImpDao();
        listarNacionalidad=aDao.listarNacionalidad();
        return listarNacionalidad;
    }

    public void setListarNacionalidad(List<Nacionalidad> listarNacionalidad) {
        this.listarNacionalidad = listarNacionalidad;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    //metodos
    public void prepararNuevoNacionalidad()
    {
        nacionalidad= new Nacionalidad();
    }
    
    public void nuevoNacionalidad()
    {
        nacionalidadDao dao= new nacionalidadImpDao();
        dao.NuevoNacionalidad(nacionalidad);
        nacionalidad= new Nacionalidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarNacionalidad()
    {
        nacionalidadDao dao= new nacionalidadImpDao();
        dao.actualizarNacionalidad(nacionalidad);
        nacionalidad= new Nacionalidad();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarNacionalidad()
    {
      nacionalidadDao dao=new nacionalidadImpDao();
      dao.borrarNacionalidad(nacionalidad);
      nacionalidad= new Nacionalidad();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
