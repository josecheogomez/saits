package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1



/**
 * Motivo generated by hbm2java
 */
public class Motivo  implements java.io.Serializable {


     private Integer motCod;
     private String motDesc;

    public Motivo() {
    }

    public Motivo(String motDesc) {
       this.motDesc = motDesc;
    }
   
    public Integer getMotCod() {
        return this.motCod;
    }
    
    public void setMotCod(Integer motCod) {
        this.motCod = motCod;
    }
    public String getMotDesc() {
        return this.motDesc;
    }
    
    public void setMotDesc(String motDesc) {
        this.motDesc = motDesc;
    }




}

