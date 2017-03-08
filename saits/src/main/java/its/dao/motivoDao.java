/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Motivo;

/**
 *
 * @author josegomez
 */
public interface motivoDao {
    public List<Motivo> listarMotivo();
    public void nuevoMotivo(Motivo motivo);
    public void actualizarMotivo(Motivo motivo);
    public void borrarMotivo(Motivo motivo);
    public Motivo obtenerMotivoPorCodigo(Session session, Integer codMotivo)throws Exception;
    
}
