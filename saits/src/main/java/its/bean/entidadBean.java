/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.entidadDao;
import its.imp.entidadImpDao;
import its.model.Entidad;

@ManagedBean
@ViewScoped
public class entidadBean {
    
    private List<Entidad> listarEntidad;
    private Entidad entidad;
    
    public entidadBean() {
        entidad= new Entidad();
    }
    
    public List<Entidad> getListarEntidad() {
        entidadDao aDao= new entidadImpDao();
        listarEntidad=aDao.listarEntidad();
        return listarEntidad;
    }

    public void setListarEntidad(List<Entidad> listarEntidad) {
        this.listarEntidad = listarEntidad;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    
    //metodos
    public void prepararNuevoEntidad()
    {
        entidad= new Entidad();
    }
    
    public void nuevoEntidad()
    {
        entidadDao dao= new entidadImpDao();
        dao.nuevoEntidad(entidad);
        entidad= new Entidad();
        
    }
    public void modificarEntidad()
    {
        entidadDao dao= new entidadImpDao();
        dao.actualizarEntidad(entidad);
        entidad= new Entidad();
    }
    public void eliminarEntidad()
    {
      entidadDao dao=new entidadImpDao();
      dao.borrarEntidad(entidad);
      entidad= new Entidad();
    }
   
}
