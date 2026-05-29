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
public class Meeting {
    private Place place;
    private String nombre;
    private LocalDate fecha;
    private int pointsEarned; 
    private String detalle;
    private String[] experiencia;

    public Meeting(Place place, String nombre, LocalDate fecha, int pointsEarned, String detalle) {
        this.place = place;
        this.nombre = nombre;
        this.fecha = fecha;
        this.pointsEarned = pointsEarned;
        this.detalle = detalle;
        this.experiencia={};
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String[] getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String[] experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Meeting{" + "place=" + place + ", nombre=" + nombre + ", fecha=" + fecha + ", pointsEarned=" + pointsEarned + ", detalle=" + detalle + ", experiencia=" + experiencia + '}';
    }
    
    
}
