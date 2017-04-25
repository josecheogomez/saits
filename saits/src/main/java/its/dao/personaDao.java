/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Persona;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author josegomez
 */
public interface personaDao {
    public List<Persona> listarPersona();
    public void NuevoPersona(Persona persona);
    public void actualizarPersona(Persona persona);
    public void borrarPersona(Persona persona);
    public Persona obtenerPersonaPorCodigo(Session session,Integer codPersona)throws Exception;
}
