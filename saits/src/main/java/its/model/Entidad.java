package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1



/**
 * Entidad generated by hbm2java
 */
public class Entidad  implements java.io.Serializable {


     private int entCod;
     private String entNom;
     private String entTel;
     private String entDir;

    public Entidad() {
    }

	
    public Entidad(int entCod) {
        this.entCod = entCod;
    }
    public Entidad(int entCod, String entNom, String entTel, String entDir) {
       this.entCod = entCod;
       this.entNom = entNom;
       this.entTel = entTel;
       this.entDir = entDir;
    }
   
    public int getEntCod() {
        return this.entCod;
    }
    
    public void setEntCod(int entCod) {
        this.entCod = entCod;
    }
    public String getEntNom() {
        return this.entNom;
    }
    
    public void setEntNom(String entNom) {
        this.entNom = entNom;
    }
    public String getEntTel() {
        return this.entTel;
    }
    
    public void setEntTel(String entTel) {
        this.entTel = entTel;
    }
    public String getEntDir() {
        return this.entDir;
    }
    
    public void setEntDir(String entDir) {
        this.entDir = entDir;
    }




}

