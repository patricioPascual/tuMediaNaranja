/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

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
    
}
