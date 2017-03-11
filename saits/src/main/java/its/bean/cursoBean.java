/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.cursoDao;
import its.imp.cursoImpDao;
import its.model.Curso;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class cursoBean {
    
    private List<Curso> listarCurso;
    private Curso curso;
    
    public cursoBean() {
        curso= new Curso();
    }
    
    public List<Curso> getListarCurso() {
        cursoDao aDao= new cursoImpDao();
        listarCurso=aDao.listarCurso();
        return listarCurso;
    }

    public void setListarCurso(List<Curso> listarCurso) {
        this.listarCurso = listarCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    //metodos
    public void prepararNuevoCurso()
    {
        curso= new Curso();
    }
    
    public void nuevoCurso()
    {
        cursoDao dao= new cursoImpDao();
        dao.nuevoCurso(curso);
        curso= new Curso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarCurso()
    {
        cursoDao dao= new cursoImpDao();
        dao.actualizarCurso(curso);
        curso= new Curso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarCurso()
    {
      cursoDao dao=new cursoImpDao();
      dao.borrarCurso(curso);
      curso= new Curso();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
