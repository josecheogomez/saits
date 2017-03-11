/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.empresaDao;
import its.imp.empresaImpDao;
import its.model.Empresa;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class empresaBean {
    
    private List<Empresa> listarEmpresa;
    private Empresa empresa;
    
    public empresaBean() {
        empresa= new Empresa();
    }
    
    public List<Empresa> getListarEmpresa() {
        empresaDao aDao= new empresaImpDao();
        listarEmpresa=aDao.listarEmpresa();
        return listarEmpresa;
    }

    public void setListarEmpresa(List<Empresa> listarEmpresa) {
        this.listarEmpresa = listarEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    //metodos
    public void prepararNuevoEmpresa()
    {
        empresa= new Empresa();
    }
    
    public void nuevoEmpresa()
    {
        empresaDao dao= new empresaImpDao();
        dao.nuevoEmpresa(empresa);
        empresa= new Empresa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto!", "Registro Exitoso"));
    }
    public void modificarEmpresa()
    {
        empresaDao dao= new empresaImpDao();
        dao.actualizarEmpresa(empresa);
        empresa= new Empresa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados"));
    }
    public void eliminarEmpresa()
    {
      empresaDao dao=new empresaImpDao();
      dao.borrarEmpresa(empresa);
      empresa= new Empresa();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Datos Borrados"));
    }
   
}
