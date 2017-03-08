/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.ciudadDao;
import its.imp.ciudadImpDao;
import its.model.Ciudad;

@ManagedBean
@ViewScoped
public class ciudadBean {
    
    private List<Ciudad> listarCiudad;
    private Ciudad ciudad;
    
    public ciudadBean() {
        ciudad= new Ciudad();
    }
    
    public List<Ciudad> getListarCiudad() {
        ciudadDao aDao= new ciudadImpDao();
        listarCiudad=aDao.listarCiudad();
        return listarCiudad;
    }

    public void setListarCiudad(List<Ciudad> listarCiudad) {
        this.listarCiudad = listarCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    //metodos
    public void prepararNuevoCiudad()
    {
        ciudad= new Ciudad();
    }
    
    public void nuevoCiudad()
    {
        ciudadDao dao= new ciudadImpDao();
        dao.nuevoCiudad(ciudad);
        ciudad= new Ciudad();
        
    }
    public void modificarCiudad()
    {
        ciudadDao dao= new ciudadImpDao();
        dao.actualizarCiudad(ciudad);
        ciudad= new Ciudad();
    }
    public void eliminarCiudad()
    {
      ciudadDao dao=new ciudadImpDao();
      dao.borrarCiudad(ciudad);
      ciudad= new Ciudad();
    }
   
}
