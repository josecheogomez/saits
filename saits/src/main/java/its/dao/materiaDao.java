/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Materia;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author josegomez
 */
public interface materiaDao {
    public List<Materia> listarMateria();
    public void NuevoMateria(Materia materia);
    public void actualizarMateria(Materia materia);
    public void borrarMateria(Materia materia);
    public Materia obtenerMateriaPorCodigo(Session session,Integer codMateria)throws Exception;
    public boolean guardarMateria(Session session,Materia materia)throws Exception;
}
