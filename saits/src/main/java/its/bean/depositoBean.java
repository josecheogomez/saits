/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.depositoDao;
import its.imp.depositoImpDao;
import its.model.Deposito;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class depositoBean {
    
    private List<Deposito> listarDeposito;
    private Deposito deposito;
    
    public depositoBean() {
        deposito= new Deposito();
    }
    
    public List<Deposito> getListarDeposito() {
        depositoDao aDao= new depositoImpDao();
        listarDeposito=aDao.listarDeposito();
        return listarDeposito;
    }

    public void setListarDeposito(List<Deposito> listarDeposito) {
        this.listarDeposito = listarDeposito;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
    
    //metodos
    public void prepararNuevoDeposito()
    {
        deposito= new Deposito();
    }
    
    public void nuevoDeposito()
    {
        depositoDao dao= new depositoImpDao();
        dao.nuevoDeposito(deposito);
        deposito= new Deposito();
        //mensaje confirmacion para growl
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
        
    }
    public void modificarDeposito()
    {
        depositoDao dao= new depositoImpDao();
        dao.actualizarDeposito(deposito);
        deposito= new Deposito();
        //mensaje confirma actualizacion
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarDeposito()
    {
      depositoDao dao=new depositoImpDao();
      dao.borrarDeposito(deposito);
      deposito= new Deposito();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
