/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import its.dao.cursoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.materiaDao;
import its.dao.semestreDao;
import its.dao.unidadDao;
import its.imp.cursoImpDao;
import its.imp.materiaImpDao;
import its.imp.semestreImpDao;
import its.imp.unidadImpDao;
import its.model.Curso;
import its.model.Materia;
import its.model.Semestre;
import its.model.Unidad;
import its.util.HibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class materiaBean {

    private List<Materia> listarMateria;
    private Materia materia;
    /*variables hibernate*/
    private Session session;
    private Transaction transaction;
    /*declarar clases*/
    private Unidad unidad;
    private Semestre semestre;
    private Curso curso;
    /*variables de codigo*/
    private Integer codigoUnidad;
    private Integer codigoSemestre;
    private Integer codigoCurso;

    public materiaBean() {
        this.materia = new Materia();
        this.unidad = new Unidad();
        this.semestre=new Semestre();
        this.curso=new Curso();
    }

    public List<Materia> getListarMateria() {
        materiaDao aDao = new materiaImpDao();
        listarMateria = aDao.listarMateria();
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Integer codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public Integer getCodigoSemestre() {
        return codigoSemestre;
    }

    public void setCodigoSemestre(Integer codigoSemestre) {
        this.codigoSemestre = codigoSemestre;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }


    //metodos
    public void prepararNuevoMateria() {
        materia = new Materia();
    }

    public void nuevoMateria() {
        materiaDao dao = new materiaImpDao();
        dao.NuevoMateria(materia);
        materia = new Materia();

    }

    public void modificarMateria() {
        materiaDao dao = new materiaImpDao();
        dao.actualizarMateria(materia);
        materia = new Materia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }

    public void eliminarMateria() {
        materiaDao dao = new materiaImpDao();
        dao.borrarMateria(materia);
        materia = new Materia();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
    /*agregar datos unidad,semestre, curso*/
    //metodo para mostrar datos Unidad por medio del dialogUnidad
    public void agregarDatosUnidad(Integer codUnidad) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            unidadDao cDao = new unidadImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.unidad = cDao.obtenerUnidadPorCodigo(this.session, codUnidad);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Unidad Agregado"));
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
    //metodo para mostrar datos Unidad por medio del codigo
    public void agregarDatosUnidad2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoUnidad == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            unidadDao cDao = new unidadImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.unidad = cDao.obtenerUnidadPorCodigo(this.session, codigoUnidad);
            if (this.unidad != null) {
                this.codigoUnidad = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Unidad Agregado"));
            } else {
                this.codigoUnidad = null;
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
    
    //datos semestre
    //metodo para mostrar datos Semestre por medio del dialogSemestre
    public void agregarDatosSemestre(Integer codSemestre) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            semestreDao cDao = new semestreImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.semestre = cDao.obtenerSemestrePorCodigo(this.session, codSemestre);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Semestre Agregado"));
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
    //metodo para mostrar datos Semestre por medio del codigo
    public void agregarDatosSemestre2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoSemestre == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            semestreDao cDao = new semestreImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.semestre = cDao.obtenerSemestrePorCodigo(this.session, codigoSemestre);
            if (this.semestre != null) {
                this.codigoSemestre = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Semestre Agregado"));
            } else {
                this.codigoSemestre = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del Semestre No encontrado"));
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
    
     //metodo para mostrar datos Curso por medio del dialogCurso
    public void agregarDatosCurso(Integer codCurso) {
        this.session = null;
        this.transaction = null;
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            cursoDao cDao = new cursoImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.curso = cDao.obtenerCursoPorCodigo(this.session, codCurso);
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Curso Agregado"));
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
    //metodo para mostrar datos Curso por medio del codigo
    public void agregarDatosCurso2() {
        this.session = null;
        this.transaction = null;
        try {
            if (codigoCurso == null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            cursoDao cDao = new cursoImpDao();
            this.transaction = this.session.beginTransaction();
            //obtener datos clientes objeto cliente segun codigo cliente
            this.curso = cDao.obtenerCursoPorCodigo(this.session, codigoCurso);
            if (this.curso != null) {
                this.codigoCurso = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del Curso Agregado"));
            } else {
                this.codigoCurso = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del Curso No encontrado"));
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

    public void guardarMateriaUSC()
    {
        this.session=null;
        this.transaction=null;
        //this.vendedor.setCodVendedor(lBean.getUsuario().getVendedor().getCodVendedor());
      
        try
        {
            this.session=HibernateUtil.getSessionFactory().openSession();
       
            materiaDao mDao= new materiaImpDao();
            
            this.transaction=this.session.beginTransaction();
            //this.factura.setCliente(this.cliente);
            //funciona si se agrega manualmente el codigo
            /*
            AL FIN GRABO ESTA PORQUERIA
            */
            this.materia.setUniCod(getUnidad().getUniCod());
            this.materia.setSemCod(getSemestre().getSemCod());
            this.materia.setCurCod(getCurso().getCurCod());
            
            mDao.guardarMateria(session, materia);
            
        
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto","Registrado"));
            this.limpiarMateria();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void limpiarMateria() {
       this.materia = new Materia();
       this.unidad =new Unidad();
       this.semestre= new Semestre();
       this.curso=new Curso();
    }
}
