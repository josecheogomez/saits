/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Barrio;

/**
 *
 * @author josegomez
 */
public interface barrioDao {
    public List<Barrio> listarBarrio();
    public void nuevoBarrio(Barrio barrio);
    public void actualizarBarrio(Barrio barrio);
    public void borrarBarrio(Barrio barrio);
    public Barrio obtenerBarrioPorCodigo(Session session, Integer codBarrio)throws Exception;
    
}
