/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Preferencias representa la descripción actual de la persona buscada por un Soltero.
 *
 * COMPOSICIÓN: Preferencias "posee" sus Criterios. Si se elimina una instancia de
 * Preferencias, sus Criterios dejan de tener sentido y deben destruirse con ella.
 *
 * El historial de preferencias anteriores queda guardado en el List<Preferencias>
 * dentro de Soltero. Solo la instancia "actual" se usa para el emparejamiento.
 */
public class Preferencia {
 
    // Composición: esta lista es PROPIA de la instancia; los Criterio no existen
    // fuera del contexto de esta Preferencias.
    private List<Criterio> atributos;
 
    private String aficiones; // texto libre para emparejamiento manual (nivel afinidad < 5)
    private LocalDate fecha;  // fecha en que se registró esta versión de preferencias
 
    // ------------------------------------------------------------------ constructor
 
    public Preferencia() {
        this.atributos = new ArrayList<>();
        this.fecha = LocalDate.now();
    }
 
    public Preferencia(List<Criterio> atributos, String aficiones) {
        if (atributos == null)
            throw new IllegalArgumentException("La lista de atributos no puede ser nula.");
        this.atributos = new ArrayList<>(atributos); // copia defensiva
        this.aficiones = aficiones;
        this.fecha = LocalDate.now();
    }
 
    // ------------------------------------------------------------------ operaciones
 
    /**
     * Agrega un nuevo criterio a la lista de preferencias.
     */
    public void agregarCriterio(Criterio criterio) {
        if (criterio == null)
            throw new IllegalArgumentException("El criterio no puede ser nulo.");
        atributos.add(criterio);
    }
 
    /**
     * Elimina un criterio por nombre.
     * @return true si se encontró y eliminó, false si no existía
     */
    public boolean eliminarCriterio(String nombre) {
        return atributos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }
 
    /**
     * Busca un criterio por nombre.
     * @return el Criterio encontrado, o null si no existe
     */
    public Criterio buscarCriterio(String nombre) {
        return atributos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
 
    /**
     * Cambia la ponderación de un criterio específico.
     * Si el criterio no existe, lanza excepción.
     */
    public void cambiarPreferencias(String nombreCriterio, int nuevaPonderacion) {
        Criterio c = buscarCriterio(nombreCriterio);
        if (c == null)
            throw new IllegalArgumentException("No existe el criterio: " + nombreCriterio);
        c.cambiarPonderacion(nuevaPonderacion);
    }
 
    /**
     * Devuelve los atributos ordenados por ponderación descendente
     * (los más importantes primero), útil para el algoritmo de emparejamiento.
     */
    public List<Criterio> getAtributosOrdenados() {
        return atributos.stream()
                .sorted((a, b) -> Integer.compare(b.getPonderacion(), a.getPonderacion()))
                .toList();
    }
 
    // ------------------------------------------------------------------ getters / setters
 
    public List<Criterio> getAtributos() { return new ArrayList<>(atributos); } // copia defensiva
 
    public String getAficiones() { return aficiones; }
    public void setAficiones(String aficiones) { this.aficiones = aficiones; }
 
    public LocalDate getFecha() { return fecha; }
 
    // ------------------------------------------------------------------ utilidad
 
    @Override
    public String toString() {
        return "Preferencias{" +
                "fecha=" + fecha +
                ", aficiones='" + aficiones + '\'' +
                ", totalCriterios=" + atributos.size() +
                '}';
    }
}
