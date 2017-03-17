/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Nacionalidad;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author josegomez
 */
public interface nacionalidadDao {
    public List<Nacionalidad> listarNacionalidad();
    public void NuevoNacionalidad(Nacionalidad nacionalidad);
    public void actualizarNacionalidad(Nacionalidad nacionalidad);
    public void borrarNacionalidad(Nacionalidad nacionalidad);
    public Nacionalidad obtenerNacionalidadPorCodigo(Session session,Integer codNacionalidad)throws Exception;
}
