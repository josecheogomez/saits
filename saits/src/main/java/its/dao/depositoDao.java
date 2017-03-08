/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Deposito;

/**
 *
 * @author josegomez
 */
public interface depositoDao {
    public List<Deposito> listarDeposito();
    public void nuevoDeposito(Deposito deposito);
    public void actualizarDeposito(Deposito deposito);
    public void borrarDeposito(Deposito deposito);
    public Deposito obtenerDepositoPorCodigo(Session session, Integer codDeposito)throws Exception;
    
}
