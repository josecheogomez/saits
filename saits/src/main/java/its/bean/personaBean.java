/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.personaDao;
import its.imp.personaImpDao;
import its.model.Persona;
import its.util.HibernateUtil;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class personaBean {
    
    private List<Persona> listarPersona;
    private Persona persona;
    private Integer codigoPersona;
    Session session;
    Transaction transaction;
    
    public personaBean() {
        persona= new Persona();
    }
    
    public List<Persona> getListarPersona() {
        personaDao aDao= new personaImpDao();
        listarPersona=aDao.listarPersona();
        return listarPersona;
    }

    public void setListarPersona(List<Persona> listarPersona) {
        this.listarPersona = listarPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    
    //metodos
    public void prepararNuevoPersona()
    {
        persona= new Persona();
    }
    
    public void nuevoPersona()
    {
        personaDao dao= new personaImpDao();
        dao.NuevoPersona(persona);
        persona= new Persona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarPersona()
    {
        personaDao dao= new personaImpDao();
        dao.actualizarPersona(persona);
        persona= new Persona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarPersona()
    {
      personaDao dao=new personaImpDao();
      dao.borrarPersona(persona);
      persona= new Persona();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
