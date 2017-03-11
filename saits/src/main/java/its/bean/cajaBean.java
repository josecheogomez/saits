/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.cajaDao;
import its.imp.cajaImpDao;
import its.model.Caja;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class cajaBean {
    
    private List<Caja> listarCaja;
    private Caja caja;
    
    public cajaBean() {
        caja= new Caja();
    }
    
    public List<Caja> getListarCaja() {
        cajaDao aDao= new cajaImpDao();
        listarCaja=aDao.listarCaja();
        return listarCaja;
    }

    public void setListarCaja(List<Caja> listarCaja) {
        this.listarCaja = listarCaja;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    
    //metodos
    public void prepararNuevoCaja()
    {
        caja= new Caja();
    }
    
    public void nuevoCaja()
    {
        cajaDao dao= new cajaImpDao();
        dao.nuevoCaja(caja);
        caja= new Caja();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarCaja()
    {
        cajaDao dao= new cajaImpDao();
        dao.actualizarCaja(caja);
        caja= new Caja();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarCaja()
    {
      cajaDao dao=new cajaImpDao();
      dao.borrarCaja(caja);
      caja= new Caja();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
