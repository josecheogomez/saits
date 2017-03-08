/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.actividadDao;
import its.imp.actividadImpDao;
import its.model.Actividad;

@ManagedBean
@ViewScoped
public class actividadBean {
    
    private List<Actividad> listarActividad;
    private Actividad actividad;
    
    public actividadBean() {
        actividad= new Actividad();
    }
    
    public List<Actividad> getListarActividad() {
        actividadDao aDao= new actividadImpDao();
        listarActividad=aDao.listarActividades();
        return listarActividad;
    }

    public void setListarActividad(List<Actividad> listarActividad) {
        this.listarActividad = listarActividad;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    //metodos
    public void prepararNuevoActividad()
    {
        actividad= new Actividad();
    }
    
    public void nuevoActividad()
    {
        actividadDao dao= new actividadImpDao();
        dao.nuevoActividad(actividad);
        actividad= new Actividad();
        
    }
    public void modificarActividad()
    {
        actividadDao dao= new actividadImpDao();
        dao.actualizarActividad(actividad);
        actividad= new Actividad();
    }
    public void eliminarActividad()
    {
      actividadDao dao=new actividadImpDao();
      dao.borrarActividad(actividad);
      actividad= new Actividad();
    }
   
}
