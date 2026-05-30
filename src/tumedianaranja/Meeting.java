
package tumedianaranja;

import java.time.LocalDate;


public class Meeting {

    private LocalDate fechaMeeting;
    private int puntosObtenidos;
    private String observaciones;
    private Place lugarReunion;

    public Meeting(LocalDate fechaMeeting, int puntosObtenidos, String observaciones, Place lugarReunion) {
        this.fechaMeeting = fechaMeeting;
        this.puntosObtenidos = puntosObtenidos;
        this.observaciones = observaciones;
        this.lugarReunion = lugarReunion;
    }

    public LocalDate getFechaMeeting() {
        return fechaMeeting;
    }

    public void setFechaMeeting(LocalDate fechaMeeting) {
        this.fechaMeeting = fechaMeeting;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Place getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(Place lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    @Override
    public String toString() {
        return "Meeting{" + "fechaMeeting=" + fechaMeeting + ", puntosObtenidos=" + puntosObtenidos + ", observaciones=" + observaciones + ", lugarReunion=" + lugarReunion + '}';
    } 
}
