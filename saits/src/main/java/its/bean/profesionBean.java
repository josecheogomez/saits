/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.profesionDao;
import its.imp.profesionImpDao;
import its.model.Profesion;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class profesionBean {
    
    private List<Profesion> listarProfesion;
    private Profesion profesion;
    
    public profesionBean() {
        profesion= new Profesion();
    }
    
    public List<Profesion> getListarProfesion() {
        profesionDao aDao= new profesionImpDao();
        listarProfesion=aDao.listarProfesion();
        return listarProfesion;
    }

    public void setListarProfesion(List<Profesion> listarProfesion) {
        this.listarProfesion = listarProfesion;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }
    
    //metodos
    public void prepararNuevoProfesion()
    {
        profesion= new Profesion();
    }
    
    public void nuevoProfesion()
    {
        profesionDao dao= new profesionImpDao();
        dao.nuevoProfesion(profesion);
        profesion= new Profesion();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarProfesion()
    {
        profesionDao dao= new profesionImpDao();
        dao.actualizarProfesion(profesion);
        profesion= new Profesion();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarProfesion()
    {
      profesionDao dao=new profesionImpDao();
      dao.borrarProfesion(profesion);
      profesion= new Profesion();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
