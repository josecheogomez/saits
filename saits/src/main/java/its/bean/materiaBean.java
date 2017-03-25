/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.materiaDao;
import its.imp.materiaImpDao;
import its.model.Materia;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class materiaBean {
    
    private List<Materia> listarMateria;
    private Materia materia;
    
    public materiaBean() {
        materia= new Materia();
    }
    
    public List<Materia> getListarMateria() {
        materiaDao aDao= new materiaImpDao();
        listarMateria=aDao.listarMateria();
        return listarMateria;
    }

    public void setListarMateria(List<Materia> listarMateria) {
        this.listarMateria = listarMateria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    //metodos
    public void prepararNuevoMateria()
    {
        materia= new Materia();
    }
    
    public void nuevoMateria()
    {
        materiaDao dao= new materiaImpDao();
        dao.NuevoMateria(materia);
        materia= new Materia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarMateria()
    {
        materiaDao dao= new materiaImpDao();
        dao.actualizarMateria(materia);
        materia= new Materia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarMateria()
    {
      materiaDao dao=new materiaImpDao();
      dao.borrarMateria(materia);
      materia= new Materia();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
