package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1



/**
 * FormaPago generated by hbm2java
 */
public class FormaPago  implements java.io.Serializable {


     private Integer fpgCod;
     private String fpgDesc;

    public FormaPago() {
    }

    public FormaPago(String fpgDesc) {
       this.fpgDesc = fpgDesc;
    }
   
    public Integer getFpgCod() {
        return this.fpgCod;
    }
    
    public void setFpgCod(Integer fpgCod) {
        this.fpgCod = fpgCod;
    }
    public String getFpgDesc() {
        return this.fpgDesc;
    }
    
    public void setFpgDesc(String fpgDesc) {
        this.fpgDesc = fpgDesc;
    }




}

