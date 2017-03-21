/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Unidad;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author josegomez
 */
public interface unidadDao {
    public List<Unidad> listarUnidad();
    public void NuevoUnidad(Unidad unidad);
    public void actualizarUnidad(Unidad unidad);
    public void borrarUnidad(Unidad unidad);
    public Unidad obtenerUnidadPorCodigo(Session session,Integer codUnidad)throws Exception;
}
