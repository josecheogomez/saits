/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Carrera;

/**
 *
 * @author josegomez
 */
public interface carreraDao {
    public List<Carrera> listarCarrera();
    public void nuevoCarrera(Carrera carrera);
    public void actualizarCarrera(Carrera carrera);
    public void borrarCarrera(Carrera carrera);
    public Carrera obtenerCarreraPorCodigo(Session session, Integer codCarrera)throws Exception;
    
}
