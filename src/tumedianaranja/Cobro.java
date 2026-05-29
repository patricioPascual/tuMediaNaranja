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
public class Cobro {
    
    private Soltero soltero;
    private Double  monto;
    private String motivo;

    public Cobro(Soltero soltero, Double monto, String motivo) {
        this.soltero = soltero;
        this.monto = monto;
        this.motivo = motivo;
    }
    
    public void cobrar(Soltero soltero){
        double cuotaBase = 11999.0;
    
   
    LocalDate haceUnAnio = LocalDate.now().minusYears(1);
    boolean masDeUnAnio = soltero.getFechaCreacion().isBefore(haceUnAnio);
    
   
   
    
    
    if (soltero.getCrush()!= null || masDeUnAnio) {
        cuotaBase= cuotaBase * 0.25; 
    }
    
        System.out.println("Se ha cobrado : " + cuotaBase + "a la tarjeta :" + soltero.getTarjetaCobro().toString());
}
    
 }

