/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Actividad;

/**
 *
 * @author josegomez
 */
public interface actividadDao {
    public List<Actividad> listarActividades();
    public void nuevoActividad(Actividad actividad);
    public void actualizarActividad(Actividad actividad);
    public void borrarActividad(Actividad actividad);
    public Actividad obtenerActividadPorCodigo(Session session, Integer codActividad)throws Exception;
    
}
