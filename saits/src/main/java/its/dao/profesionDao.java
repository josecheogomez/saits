/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Profesion;

/**
 *
 * @author josegomez
 */
public interface profesionDao {
    public List<Profesion> listarProfesion();
    public void nuevoProfesion(Profesion profesion);
    public void actualizarProfesion(Profesion profesion);
    public void borrarProfesion(Profesion profesion);
    public Profesion obtenerProfesionPorCodigo(Session session, Integer codProfesion)throws Exception;
    
}
