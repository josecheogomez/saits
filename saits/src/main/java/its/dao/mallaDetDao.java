/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.dao;

import its.model.MallaDet;
import org.hibernate.Session;

/**
 *
 * @author José Gómez
 */
public interface mallaDetDao {
    public boolean guardarMallaDet(Session session, MallaDet mallaDetalle)throws Exception;
}
