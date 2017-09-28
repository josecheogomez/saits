/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.Malla;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author José Gómez
 */
public interface mallaDao {
    public List<Malla> listarMalla();
    public void NuevoMalla(Malla malla);
    public void actualizarMalla(Malla malla);
    public void borrarMalla(Malla malla);
    public Malla obtenerMallaPorCodigo(Session session, Integer codMalla) throws Exception;
    public Malla obtenerUltimoRegistro(Session session)throws Exception;
    public long obtenerTotalRegistro(Session session);
    public boolean guardarMalla(Session session, Malla malla)throws Exception;
}
