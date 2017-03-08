/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Caja;

/**
 *
 * @author josegomez
 */
public interface cajaDao {
    public List<Caja> listarCaja();
    public void nuevoCaja(Caja caja);
    public void actualizarCaja(Caja caja);
    public void borrarCaja(Caja caja);
    public Caja obtenerCajaPorCodigo(Session session, Integer codCaja)throws Exception;
    
}
