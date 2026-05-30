
package tumedianaranja;

import java.util.Date;


public class MedioDePago {
    
    public Soltero duenoTarjeta;
    public String nroTarjeta;
    public String titular;
    public Date fechaExpira;
    public String banco;
    public Double saldo;
    public int codSeguridad;
    public String motivoGasto;

    public MedioDePago(String nroTarjeta, String titular, Date fechaExpira, String banco, Double saldo, int codSeguridad) {
        this.nroTarjeta = nroTarjeta;
        this.titular = titular;
        this.fechaExpira = fechaExpira;
        this.banco = banco;
        this.saldo = saldo;
        this.codSeguridad = codSeguridad;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getFechaExpira() {
        return fechaExpira;
    }

    public void setFechaExpira(Date fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(int codSeguridad) {
        this.codSeguridad = codSeguridad;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


