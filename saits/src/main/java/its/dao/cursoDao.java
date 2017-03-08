/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Curso;

/**
 *
 * @author josegomez
 */
public interface cursoDao {
    public List<Curso> listarCurso();
    public void nuevoCurso(Curso curso);
    public void actualizarCurso(Curso curso);
    public void borrarCurso(Curso curso);
    public Curso obtenerCursoPorCodigo(Session session, Integer codCurso)throws Exception;
    
}
