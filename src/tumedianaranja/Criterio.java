/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.util.Scanner;

/**
 *
 * @author patri
 */
public class Criterio {
    private String nombre;
    private Object valorDeseado;
    private int ponderacion; 

    public Criterio(String nombre, Object valorDeseado, int ponderacion) {
        this.nombre = nombre;
        this.valorDeseado = valorDeseado;
        this.ponderacion = ponderacion;
    }

    @Override
    public String toString() {
        return "Criterio{" + "nombre=" + nombre + ", valorDeseado=" + valorDeseado + ", ponderacion=" + ponderacion + '}';
    }

    public Criterio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getValorDeseado() {
        return valorDeseado;
    }

    public void setValorDeseado(Object valorDeseado) {
        this.valorDeseado = valorDeseado;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }
    
    public static Criterio crearCriterio() {
        Scanner teclado = new Scanner(System.in);

      
        System.out.print("Ingrese el nombre del criterio: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese la ponderación (número entero): ");
        int ponderacion = teclado.nextInt();
        
      
        System.out.println("¿Qué tipo de valor desea ingresar?");
        System.out.println("1. Texto (String)");
        System.out.println("2. Número entero (Integer)");
        System.out.println("3. Verdadero/Falso (Boolean)");
        System.out.print("Seleccione una opción: ");
        int opcion = teclado.nextInt();
        teclado.nextLine(); 

        Object valorDeseado = null;

       
        if (opcion == 1) {
            System.out.print("Ingrese el texto deseado: ");
            valorDeseado = teclado.nextLine(); 
        } else if (opcion == 2) {
            System.out.print("Ingrese el número deseado: ");
            valorDeseado = teclado.nextInt(); 
        } else if (opcion == 3) {
            System.out.print("Ingrese el valor (true/false): ");
            valorDeseado = teclado.nextBoolean();
        }

        
        Criterio nuevoCriterio = new Criterio(nombre, valorDeseado, ponderacion);
        return nuevoCriterio;
    }
    
    
}

