/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.barrioDao;
import its.imp.barrioImpDao;
import its.model.Barrio;

@ManagedBean
@ViewScoped
public class barrioBean {
    
    private List<Barrio> listarBarrio;
    private Barrio barrio;
    
    public barrioBean() {
        barrio= new Barrio();
    }
    
    public List<Barrio> getListarBarrio() {
        barrioDao aDao= new barrioImpDao();
        listarBarrio=aDao.listarBarrio();
        return listarBarrio;
    }

    public void setListarBarrio(List<Barrio> listarBarrio) {
        this.listarBarrio = listarBarrio;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }
    
    //metodos
    public void prepararNuevoBarrio()
    {
        barrio= new Barrio();
    }
    
    public void nuevoBarrio()
    {
        barrioDao dao= new barrioImpDao();
        dao.nuevoBarrio(barrio);
        barrio= new Barrio();
        
    }
    public void modificarBarrio()
    {
        barrioDao dao= new barrioImpDao();
        dao.actualizarBarrio(barrio);
        barrio= new Barrio();
    }
    public void eliminarBarrio()
    {
      barrioDao dao=new barrioImpDao();
      dao.borrarBarrio(barrio);
      barrio= new Barrio();
    }
   
}
