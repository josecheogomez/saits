/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import its.dao.motivoDao;
import its.imp.motivoImpDao;
import its.model.Motivo;

@ManagedBean
@ViewScoped
public class motivoBean {
    
    private List<Motivo> listarMotivo;
    private Motivo motivo;
    
    public motivoBean() {
        motivo= new Motivo();
    }
    
    public List<Motivo> getListarMotivo() {
        motivoDao aDao= new motivoImpDao();
        listarMotivo=aDao.listarMotivo();
        return listarMotivo;
    }

    public void setListarMotivo(List<Motivo> listarMotivo) {
        this.listarMotivo = listarMotivo;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }
    
    //metodos
    public void prepararNuevoMotivo()
    {
        motivo= new Motivo();
    }
    
    public void nuevoMotivo()
    {
        motivoDao dao= new motivoImpDao();
        dao.nuevoMotivo(motivo);
        motivo= new Motivo();
        
    }
    public void modificarMotivo()
    {
        motivoDao dao= new motivoImpDao();
        dao.actualizarMotivo(motivo);
        motivo= new Motivo();
    }
    public void eliminarMotivo()
    {
      motivoDao dao=new motivoImpDao();
      dao.borrarMotivo(motivo);
      motivo= new Motivo();
    }
   
}
