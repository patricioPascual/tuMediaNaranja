/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author patri
 */
public class Preferencias {
    private ArrayList<Criterio> atributos;
    private String aficiones;
    private LocalDate fecha;

      public Preferencias() {
        
        this.fecha = LocalDate.now();
        this.atributos = new ArrayList<>();
        
       
        
      
        Criterio c1 = new Criterio();
        c1.setNombre("Estado Civil");
        c1.setValorDeseado("Soltero/a");
        c1.setPonderacion(3);
        this.atributos.add(c1);

       
        Criterio c2 = new Criterio();
        c2.setNombre("Margen de Edad");
        c2.setValorDeseado(new Margen(25, 35));
        c2.setPonderacion(5);
        this.atributos.add(c2);

  
        Criterio c3 = new Criterio();
        c3.setNombre("Acepta Hijos");
        c3.setValorDeseado(Boolean.TRUE);
        c3.setPonderacion(4);
        this.atributos.add(c3);

        
        Criterio c4 = new Criterio();
        c4.setNombre("Nivel Cultural");
        c4.setValorDeseado("Universitario Completo");
        c4.setPonderacion(2);
        this.atributos.add(c4);

        
        Criterio c5 = new Criterio();
        c5.setNombre("Margen Estatura");
        c5.setValorDeseado((1.60));
        c5.setPonderacion(1);
        this.atributos.add(c5);

      
        Criterio c6 = new Criterio();
        c6.setNombre("Margen Peso");
        c6.setValorDeseado(70.0));
        c6.setPonderacion(1);
        this.atributos.add(c6);

       
        Criterio c7 = new Criterio();
        c7.setNombre("Color de Pelo");
        c7.setValorDeseado("Castaño");
        c7.setPonderacion(2);
        this.atributos.add(c7);

     
        Criterio c8 = new Criterio();
        c8.setNombre("Color de Ojos");
        c8.setValorDeseado("Verdes");
        c8.setPonderacion(2);
        this.atributos.add(c8);

        Criterio c9 = new Criterio();
        c9.setNombre("Personalidad: Cariñoso");
        c9.setValorDeseado(Integer.valueOf(8));
        c9.setPonderacion(3);
        this.atributos.add(c9);

        
        Criterio c10 = new Criterio();
        c10.setNombre("Personalidad: Alegre");
        c10.setValorDeseado(Integer.valueOf(9));
        c10.setPonderacion(3);
        this.atributos.add(c10);

      
        Criterio c11 = new Criterio();
        c11.setNombre("Personalidad: Compañero");
        c11.setValorDeseado(Integer.valueOf(10));
        c11.setPonderacion(5);
        this.atributos.add(c11);

        
        Criterio c12 = new Criterio();
        c12.setNombre("Personalidad: Salidor");
        c12.setValorDeseado(Boolean.TRUE);
        c12.setPonderacion(4);
        this.atributos.add(c12);
    }
    
   
    

    public ArrayList<Criterio> getCriterios() {
        return atributos;
    }

    public String getAficiones() {
        return aficiones;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void mostrarPreferencias(){
        for(Criterio aux: atributos){
            System.out.println(aux.toString());
        }
        System.out.println("Aficiones :" + aficiones);
        
    }
     public void cargarCriterio(String nombre,Object valor,int ponderacion){
       
        Criterio nuevoCriterio= new Criterio(nombre,valor,ponderacion);
        
    }
}
