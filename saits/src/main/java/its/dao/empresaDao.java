/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import java.util.List;
import org.hibernate.Session;
import its.model.Empresa;

/**
 *
 * @author josegomez
 */
public interface empresaDao {
    public List<Empresa> listarEmpresa();
    public void nuevoEmpresa(Empresa empresa);
    public void actualizarEmpresa(Empresa empresa);
    public void borrarEmpresa(Empresa empresa);
    public Empresa obtenerEmpresaPorCodigo(Session session, Integer codEmpresa)throws Exception;
    
}
