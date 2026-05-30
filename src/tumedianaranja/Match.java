
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;



public class Match {
    
    public LocalDate fechaInicio;
    public LocalDate fechaFin;
    public Soltero solteroA;
    public Soltero solteroB;
    public String resultado;
    public int totalPoints;
    public Meeting meeting;
    ArrayList<Meeting> meetings;
    public String detallesDeFeedback;
    public String comentariosAdicionales;

    public Match(LocalDate fechaInicio, LocalDate fechaFin, Soltero solteroA, Soltero solteroB, String resultado, int totalPoints, Meeting meeting, ArrayList<Meeting> meetings, String detallesDeFeedback, String comentariosAdicionales) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.solteroA = solteroA;
        this.solteroB = solteroB;
        this.resultado = resultado;
        this.totalPoints = totalPoints;
        this.meeting = meeting;
        this.meetings = meetings;
        this.detallesDeFeedback = detallesDeFeedback;
        this.comentariosAdicionales = comentariosAdicionales;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Soltero getSolteroA() {
        return solteroA;
    }

    public void setSolteroA(Soltero solteroA) {
        this.solteroA = solteroA;
    }

    public Soltero getSolteroB() {
        return solteroB;
    }

    public void setSolteroB(Soltero solteroB) {
        this.solteroB = solteroB;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    public String getDetallesDeFeedback() {
        return detallesDeFeedback;
    }

    public void setDetallesDeFeedback(String detallesDeFeedback) {
        this.detallesDeFeedback = detallesDeFeedback;
    }

    public String getComentariosAdicionales() {
        return comentariosAdicionales;
    }

    public void setComentariosAdicionales(String comentariosAdicionales) {
        this.comentariosAdicionales = comentariosAdicionales;
    }
    
    public void VideoChat(Soltero soltero1, Soltero soltero2) {
        
        System.out.println("El soltero 1: " + soltero1.getNombreCompleto() + " inicio un videochat con el soltero 2: " + soltero2.getNombreCompleto());
        
        
    }
   
    
    
    
    
    public static void registrarFeedbacks(String detallesA, boolean esPositivoA, String comentariosA, String detallesB, boolean esPositivoB, String comentariosB) {
        
        System.out.println("--- Feedback del Match ---");
        
        // Feedback de Soltero a
        System.out.println("El soltero A ingreso este feedback:");
        System.out.println("Detalles: " + detallesA);
        System.out.println("Definicion(positivo o negativo): " + (esPositivoA ? "Sí" : "No"));
        System.out.println("Info Adicional: " + comentariosA);

        System.out.println("-------------------------------------");

        // Feedback de Soltero b
        System.out.println("El soltero B ingresó este feedback:");
        System.out.println("Detalles: " + detallesB);
        System.out.println("Definicion(positivo o negativo): " + (esPositivoB ? "Sí" : "No"));
        System.out.println("Info Adicional: " + comentariosB);
    }
    
    
    
    public void comprobacionInactividad(Soltero a, Soltero b){  
        LocalDate hoy = LocalDate.now();
        if(fechaInicio.compareTo(hoy) >= 30 && meetings.isEmpty()){ 
            fechaFin = hoy; 
            resultado = "DISLIKE";
            cobrarServicioConRecargo(a);
            cobrarServicioConRecargo(b);
            System.out.println("Se cobro el servicio a los dos solteros por inactividad");
        } else{
            System.out.println("No se cobro el servicio a los dos solteros por inactividad");
        }               
    }
    
    // tarifa con recargo: 18000 pesos;
    public void cobrarServicioConRecargo(Soltero solteroCobrado){
        
        Double tarifaRecargada = 18000.0;
        Double nuevoSaldo = solteroCobrado.getMedioDePago().saldo - tarifaRecargada;
        solteroCobrado.getMedioDePago().setSaldo(nuevoSaldo);
        System.out.println("Se realizo un cobro recargado al soltero: " + solteroCobrado.getNombreCompleto());
    }
    
    //tarifa normal 14000
    public void cobrarServicioNormal(Soltero solteroCobrado){
        if(solteroCobrado.getCrush() == null){
            Double tarifaNormal = 12000.0;
            Double nuevoSaldo = solteroCobrado.getMedioDePago().saldo - tarifaNormal;
            solteroCobrado.getMedioDePago().setSaldo(nuevoSaldo);
            System.out.println("Se realizo un cobro especial por no tener crush al soltero: " + solteroCobrado.getNombreCompleto());
        } else if(solteroCobrado.getCrush() != null || solteroCobrado.getFechaCreacion().isBefore(LocalDate.now().minusDays(365))){
            Double tarifaNormal = 3000.0;
            Double nuevoSaldo = solteroCobrado.getMedioDePago().saldo - tarifaNormal;
            solteroCobrado.getMedioDePago().setSaldo(nuevoSaldo);
            System.out.println("Se realizo un cobro especial por tener crush o estar mas de 1 year, al soltero: " + solteroCobrado.getNombreCompleto());
        } 
        else{
            Double tarifaNormal = 14000.0;
            Double nuevoSaldo = solteroCobrado.getMedioDePago().saldo - tarifaNormal;
            solteroCobrado.getMedioDePago().setSaldo(nuevoSaldo);
            System.out.println("Se realizo un cobro normal; al soltero: " + solteroCobrado.getNombreCompleto());
        }
        
    }
    
    public void finalizarMatch(Soltero a, Soltero b){
        
        if(a.getCrush() != null && b.getCrush() != null){
            a.setCrush(null);
            b.setCrush(null);
            System.out.println("Se dio de baja el match entre los solteros: " + a.getNombreCompleto() + ", " + b.getNombreCompleto());
        } else{
            System.out.println("Los solteros no coinciden haciendo match, por lo tanto no se cancela");
        }
        
        
    }
    
    public void verLugares(ArrayList<Meeting> insertarMeetings){
        for(Meeting meetingListado : insertarMeetings){
            
            System.out.println(meetingListado.getLugarReunion().getNombre());
            
        }
    }
    
    public static void listarMeetings(ArrayList<Meeting> insertarMeetings){
        
        for(Meeting meetingListado : insertarMeetings){
            System.out.println(meetingListado);
        }
        
    }  
}
