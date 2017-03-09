/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Entidad;

/**
 *
 * @author josegomez
 */
public interface entidadDao {
    public List<Entidad> listarEntidad();
    public void nuevoEntidad(Entidad entidad);
    public void actualizarEntidad(Entidad entidad);
    public void borrarEntidad(Entidad entidad);
    public Entidad obtenerEntidadPorCodigo(Session session, Integer codEntidad)throws Exception;
    
}
