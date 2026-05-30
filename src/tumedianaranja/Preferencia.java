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
    private String aficiones;
    private LocalDate fecha;

      public Preferencia(Scanner teclado) {
        
        this.fecha = LocalDate.now();
        this.atributos = new ArrayList<>();
        
        System.out.println("\n--- CONFIGURACIÓN DE PREFERENCIAS DE PAREJA ---");
        
        System.out.print("Ingrese aficiones generales (ej: lectura, cine): ");
        this.aficiones = teclado.nextLine();

        // 1. Estado Civil (String)
        System.out.print("Estado Civil deseado: ");
        cargarCriterio("Estado Civil", teclado.nextLine(), cargarPonderacion());

        // 2. Margen de Edad (Objeto Margen)
        System.out.print("Margen de edad - Mínimo: ");
        int edadMin = teclado.nextInt();
        System.out.print("Margen de edad - Máximo: ");
        int edadMax = teclado.nextInt();
        agregarCriterio("Margen de Edad", new Margen(edadMin, edadMax), 5);

        // 3. ¿Acepta hijos? (Boolean)
        System.out.print("¿Acepta que tenga hijos? (true/false): ");
        cargarCriterio("Acepta Hijos", teclado.nextBoolean(), 4);
        teclado.nextLine(); // Limpiar el buffer

        // 4. Nivel Cultural (String)
        System.out.print("Nivel Cultural mínimo deseado: ");
        cargarCriterio("Nivel Cultural", teclado.nextLine(), 2);

        // 5. Margen Estatura (Objeto Margen)
        System.out.print("Margen estatura - Mínima (ej: 1.60): ");
        double estMin = teclado.nextDouble();
        System.out.print("Margen estatura - Máxima (ej: 1.85): ");
        double estMax = teclado.nextDouble();
        cargarCriterio("Margen Estatura", (estMin, estMax), 1);

        // 6. Margen Peso (Objeto Margen)
        System.out.print("Margen peso - Máximo (en kg): ");
        double pesoMax = teclado.nextDouble();
        agregarCriterio("Margen Peso", pesoMax);
        teclado.nextLine(); // Limpiar el buffer

        // 7. Color de Pelo (String)
        System.out.print("Color de pelo deseado: ");
        cargarCriterio("Color de Pelo", teclado.nextLine(), 2);

        // 8. Color de Ojos (String)
        System.out.print("Color de ojos deseado: ");
        cargarCriterio("Color de Ojos", teclado.nextLine(), 2);

        // 9. Cariñoso/a (Integer - Escala 1 al 10)
        System.out.print("Nivel de afecto esperado (Cariñoso/a del 1 al 10): ");
        cargarCriterio("Personalidad: Cariñoso", teclado.nextInt(), 3);

        // 10. Alegre (Integer - Escala 1 al 10)
        System.out.print("Nivel de alegría esperado (Alegre del 1 al 10): ");
        cargarCriterio("Personalidad: Alegre", teclado.nextInt(), 3);

        // 11. Compañero/a (Integer - Escala 1 al 10)
        System.out.print("Nivel de compañerismo esperado (Compañero/a del 1 al 10): ");
        cargarCriterio("Personalidad: Compañero", teclado.nextInt(), 5);

        // 12. Salidor/a (Boolean)
        System.out.print("¿Debe ser una persona salidora? (true/false): ");
        cargarCriterio("Personalidad: Salidor", teclado.nextBoolean(), 4);
        teclado.nextLine(); // Limpiar el buffer final
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
    
     public int cargarPonderacion() {
         Scanner teclado = new Scanner(System.in);
         System.out.println("Ingresa el valor de interes del 1 al 5");
         int ponderacion = teclado.nextInt();
         return ponderacion;
     }
}
