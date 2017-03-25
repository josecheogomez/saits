/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Semestre;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author josegomez
 */
public interface semestreDao {
    public List<Semestre> listarSemestre();
    public void NuevoSemestre(Semestre semestre);
    public void actualizarSemestre(Semestre semestre);
    public void borrarSemestre(Semestre semestre);
    public Semestre obtenerSemestrePorCodigo(Session session,Integer codSemestre)throws Exception;
}
