package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Timbrado generated by hbm2java
 */
public class Timbrado  implements java.io.Serializable {


     private Integer timCod;
     private String timNro;
     private Date timFecIni;
     private Date timFecFin;

    public Timbrado() {
    }

    public Timbrado(String timNro, Date timFecIni, Date timFecFin) {
       this.timNro = timNro;
       this.timFecIni = timFecIni;
       this.timFecFin = timFecFin;
    }
   
    public Integer getTimCod() {
        return this.timCod;
    }
    
    public void setTimCod(Integer timCod) {
        this.timCod = timCod;
    }
    public String getTimNro() {
        return this.timNro;
    }
    
    public void setTimNro(String timNro) {
        this.timNro = timNro;
    }
    public Date getTimFecIni() {
        return this.timFecIni;
    }
    
    public void setTimFecIni(Date timFecIni) {
        this.timFecIni = timFecIni;
    }
    public Date getTimFecFin() {
        return this.timFecFin;
    }
    
    public void setTimFecFin(Date timFecFin) {
        this.timFecFin = timFecFin;
    }




}


