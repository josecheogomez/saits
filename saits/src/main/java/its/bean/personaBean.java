/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import its.dao.ciudadDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.personaDao;
import its.imp.ciudadImpDao;
import its.imp.personaImpDao;
import its.model.Actividad;
import its.model.Barrio;
import its.model.Ciudad;
import its.model.Nacionalidad;
import its.model.Persona;
import its.model.Profesion;
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
    private Ciudad ciudad;
    private Barrio barrio;
    private Nacionalidad nacionalidad;
    private Profesion profesion;
    private Actividad actividad;
    //variables
    private Integer codigoCiudad;
    
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Integer getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Integer codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
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
    //metodo para agregar datos
    public void agregarDatosCiudad(Integer codCiudad) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            ciudadDao cDao = new ciudadImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.ciudad = cDao.obtenerCiudadPorCodigo(this.session, codCiudad);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Agregado"));
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
     public void agregarDatosCiudad2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoCiudad == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            ciudadDao cDao = new ciudadImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.ciudad = cDao.obtenerCiudadPorCodigo(this.session, codigoCiudad);
            if (this.ciudad != null) {
                this.codigoCiudad = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Unidad Agregado"));
            } else {
                this.codigoCiudad = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del Unidad No encontrado"));
            }
            this.transaction.commit();
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Datos del Cliente Agregado"));
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
