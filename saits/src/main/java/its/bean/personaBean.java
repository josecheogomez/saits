/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import its.dao.barrioDao;
import its.dao.ciudadDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.personaDao;
import its.imp.barrioImpDao;
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
    private Integer codigoBarrio;
    private Integer codigoNacionalidad;
    private Integer codigoProfesion;
    private Integer codigoActividad;
    
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

    public Integer getCodigoBarrio() {
        return codigoBarrio;
    }

    public void setCodigoBarrio(Integer codigoBarrio) {
        this.codigoBarrio = codigoBarrio;
    }

    public Integer getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    public void setCodigoNacionalidad(Integer codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad;
    }

    public Integer getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(Integer codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
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
    //metodo para agregar datos al buscador ciudad
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
     
     //metodo para agregar datos al buscador ciudad
    public void agregarDatosBarrio(Integer codBarrio) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            barrioDao cDao = new barrioImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.barrio = cDao.obtenerBarrioPorCodigo(this.session, codBarrio);
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
     public void agregarDatosBarrio2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoBarrio == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            barrioDao cDao = new barrioImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.barrio = cDao.obtenerBarrioPorCodigo(this.session, codigoBarrio);
            if (this.barrio != null) {
                this.codigoBarrio = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Unidad Agregado"));
            } else {
                this.codigoBarrio = null;
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
