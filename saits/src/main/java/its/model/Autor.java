package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1



/**
 * Autor generated by hbm2java
 */
public class Autor  implements java.io.Serializable {


     private Integer autCod;
     private String autNom;
     private String autApe;
     private String autWeb;

    public Autor() {
    }

    public Autor(String autNom, String autApe, String autWeb) {
       this.autNom = autNom;
       this.autApe = autApe;
       this.autWeb = autWeb;
    }
   
    public Integer getAutCod() {
        return this.autCod;
    }
    
    public void setAutCod(Integer autCod) {
        this.autCod = autCod;
    }
    public String getAutNom() {
        return this.autNom;
    }
    
    public void setAutNom(String autNom) {
        this.autNom = autNom;
    }
    public String getAutApe() {
        return this.autApe;
    }
    
    public void setAutApe(String autApe) {
        this.autApe = autApe;
    }
    public String getAutWeb() {
        return this.autWeb;
    }
    
    public void setAutWeb(String autWeb) {
        this.autWeb = autWeb;
    }




}

