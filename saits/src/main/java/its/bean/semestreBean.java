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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class semestreBean {
    
    private List<Semestre> listarSemestre;
    private Semestre semestre;
    
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
   
}
