package its.model;
// Generated 06/03/2017 11:36:42 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Facturacion generated by hbm2java
 */
public class Facturacion  implements java.io.Serializable {


     private FacturacionId id;
     private Date facCarg;
     private String facNro;
     private Character facEst;
     private String facTipoPago;
     private int insCod;
     private int perCod;
     private int timCod;

    public Facturacion() {
    }

	
    public Facturacion(FacturacionId id, int insCod, int perCod, int timCod) {
        this.id = id;
        this.insCod = insCod;
        this.perCod = perCod;
        this.timCod = timCod;
    }
    public Facturacion(FacturacionId id, Date facCarg, String facNro, Character facEst, String facTipoPago, int insCod, int perCod, int timCod) {
       this.id = id;
       this.facCarg = facCarg;
       this.facNro = facNro;
       this.facEst = facEst;
       this.facTipoPago = facTipoPago;
       this.insCod = insCod;
       this.perCod = perCod;
       this.timCod = timCod;
    }
   
    public FacturacionId getId() {
        return this.id;
    }
    
    public void setId(FacturacionId id) {
        this.id = id;
    }
    public Date getFacCarg() {
        return this.facCarg;
    }
    
    public void setFacCarg(Date facCarg) {
        this.facCarg = facCarg;
    }
    public String getFacNro() {
        return this.facNro;
    }
    
    public void setFacNro(String facNro) {
        this.facNro = facNro;
    }
    public Character getFacEst() {
        return this.facEst;
    }
    
    public void setFacEst(Character facEst) {
        this.facEst = facEst;
    }
    public String getFacTipoPago() {
        return this.facTipoPago;
    }
    
    public void setFacTipoPago(String facTipoPago) {
        this.facTipoPago = facTipoPago;
    }
    public int getInsCod() {
        return this.insCod;
    }
    
    public void setInsCod(int insCod) {
        this.insCod = insCod;
    }
    public int getPerCod() {
        return this.perCod;
    }
    
    public void setPerCod(int perCod) {
        this.perCod = perCod;
    }
    public int getTimCod() {
        return this.timCod;
    }
    
    public void setTimCod(int timCod) {
        this.timCod = timCod;
    }




}


