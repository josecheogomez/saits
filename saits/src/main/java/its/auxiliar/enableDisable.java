/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.auxiliar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
/**
 *
 * @author José Gómez
 */
public class enableDisable {
    private boolean enable;
    //metodo para habilitar y desabilitar controles
    public boolean activar()
    {
    return enable;
    }
    public void activarBoton(){
    enable=true;
    }
    public void desactivarBoton(){
    enable=false;
    }
}
