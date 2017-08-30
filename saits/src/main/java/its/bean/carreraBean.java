/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.carreraDao;
import its.imp.carreraImpDao;
import its.model.Carrera;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class carreraBean implements Serializable{
    
    private List<Carrera> listarCarrera;
    private Carrera carrera;
    
    public carreraBean() {
        carrera= new Carrera();
    }
    
    public List<Carrera> getListarCarrera() {
        carreraDao aDao= new carreraImpDao();
        listarCarrera=aDao.listarCarrera();
        return listarCarrera;
    }

    public void setListarCarrera(List<Carrera> listarCarrera) {
        this.listarCarrera = listarCarrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    //metodos
    public void prepararNuevoCarrera()
    {
        carrera= new Carrera();
    }
    
    public void nuevoCarrera()
    {
        carreraDao dao= new carreraImpDao();
        dao.nuevoCarrera(carrera);
        carrera= new Carrera();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarCarrera()
    {
        carreraDao dao= new carreraImpDao();
        dao.actualizarCarrera(carrera);
        carrera= new Carrera();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarCarrera()
    {
      carreraDao dao=new carreraImpDao();
      dao.borrarCarrera(carrera);
      carrera= new Carrera();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
  // public void agregar
    
}
