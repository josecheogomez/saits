/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Ciudad;

/**
 *
 * @author josegomez
 */
public interface ciudadDao {
    public List<Ciudad> listarCiudad();
    public void nuevoCiudad(Ciudad ciudad);
    public void actualizarCiudad(Ciudad ciudad);
    public void borrarCiudad(Ciudad ciudad);
    public Ciudad obtenerCiudadPorCodigo(Session session, Integer codCiudad)throws Exception;
    
}
