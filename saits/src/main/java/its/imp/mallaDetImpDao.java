/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.imp;

import its.dao.mallaDetDao;
import its.model.MallaDet;
import org.hibernate.Session;

/**
 *
 * @author José Gómez
 */
public class mallaDetImpDao implements mallaDetDao{

    @Override
    public boolean guardarMallaDet(Session session, MallaDet mallaDetalle) throws Exception {
        session.save(mallaDetalle);
        return true;
    }
    
}
