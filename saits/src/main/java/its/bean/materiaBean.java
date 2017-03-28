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

    public materiaBean() {
        materia = new Materia();
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

    public void guardarMateria()
    {
        this.session=null;
        this.transaction=null;
        //this.vendedor.setCodVendedor(lBean.getUsuario().getVendedor().getCodVendedor());
        try
        {
            this.session=HibernateUtil.getSessionFactory().openSession();
            unidadDao pDao=new unidadImpDao();
            semestreDao fDao=new semestreImpDao();
            cursoDao dFDao=new cursoImpDao();
            materiaDao mDao= new materiaImpDao();
            
            this.transaction=this.session.beginTransaction();
            //this.factura.setCliente(this.cliente);
            this.materia.setUnidad(this.unidad);
            this.materia.setSemestre(this.semestre);
            this.materia.setCurso(this.curso);
            //this.factura.setVendedor(this.vendedor);
            
            //insert en la tabla factura
            mDao.guardarMateria(session, materia);
            
            //recuperar el ultimo registro de la tabla factura
           // this.factura =fDao.obtenerUltimoRegistro(session);
            //recorremos arrayList guardar en la db
           /* for(Detallefactura item: listaDetalleFactura)
            {
            this.producto=pDao.obtenerProductoPorCodBarra(session, item.getCodBarra());
            item.setFactura(factura);
            item.setProducto(producto);
            //hacemos insert detalle factura
            dFDao.guardarVentaDetalleFactura(session, item);
            }*/
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto","Registrado"));
            //this.limpiarFactura();
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
}
