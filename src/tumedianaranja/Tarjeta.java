/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;

/**
 *
 * @author patri
 */
public class Tarjeta {
    private String titular;
    private LocalDate fechaExpiracion;
    private long numero;
    private String Banco;
    public Tarjeta(String titular, LocalDate fechaExpiracion, long numero, String Banco) {
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
        this.numero = numero;
        this.Banco = Banco;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "titular=" + titular + ", fechaExpiracion=" + fechaExpiracion + ", numero=" + numero + ", Banco=" + Banco + '}';
    }
    
}
