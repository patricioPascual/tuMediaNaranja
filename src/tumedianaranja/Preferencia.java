/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author patri
 */
public class Preferencia {
    private ArrayList<Criterio> atributos;
    private ArrayList<String> aficiones;
    private LocalDate fecha;

    public Preferencia(ArrayList<String> aficiones, LocalDate fecha) {
        this.aficiones = aficiones;
        this.fecha = fecha;
        this.atributos= new ArrayList();
        this.cargarCriterios();
    }

      
   
    

    public ArrayList<Criterio> getCriterios() {
        return atributos;
    }

    public ArrayList getAficiones() {
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
     public void cargarCriterios(){
         Scanner teclado=new Scanner(System.in);
        boolean salir=false;
        while (salir==false){
            
        Criterio nuevoCriterio= Criterio.crearCriterio();
        atributos.add(nuevoCriterio);
            System.out.println("Desea agregar otro Criterio??");
            String entrada= teclado.nextLine();
            if(entrada.equalsIgnoreCase("no")){
                salir=true;
            }
    }
     }
    
}
