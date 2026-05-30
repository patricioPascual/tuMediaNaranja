/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Soltero es la entidad central del sistema.
 *
 * COMPOSICIÓN:
 *   - Soltero "posee" un Perfil (no puede existir sin su Soltero).
 *   - Soltero "posee" un historial de Preferencias (List):
 *       · historialPreferencias guarda TODAS las versiones anteriores.
 *       · preferenciaActual es la que se usa para el emparejamiento.
 *
 * AUTORREFERENCIA:
 *   - crush apunta a otro Soltero (puede ser null si no hay match activo).
 */
public class Soltero {
 
    // --- Composición con Perfil (obligatorio, 1..1) ---
    private Perfil perfil;
 
    // --- Composición con Preferencias (historial + actual) ---
    private List<Preferencia> historialPreferencias; // versiones anteriores
    private Preferencia preferenciaActual;           // usada en el emparejamiento
 
    // --- Datos personales (visibilidad privada, acceso por getters) ---
    private String nombreCompleto;
    private String dni;
    private String domicilio;
    private String email;
    private String direccion;
    private String estadoCivil;
    private String sexo;
    private int edad;
    private boolean hijos;
 
    // --- Autorreferencia: pareja actual (null = sin match) ---
    private Soltero crush;
 
    // --- Otros ---
    private Tarjeta tarjetaCobro;
    private List<StoryMatch> story;      // historial de matches (puede modelarse luego)
    private LocalDate fechaCreacion;
 
    // Estado de búsqueda: "single" | "matched" | "unmatched"
    private String estadoBusqueda;
 
    // ------------------------------------------------------------------ constructor
 
    /**
     * Constructor principal. El Perfil se crea junto con el Soltero (composición).
     */
    public Soltero(String nombreCompleto, String dni, String domicilio,
                   String email, String direccion, String estadoCivil,
                   String sexo, int edad, boolean hijos, Tarjeta tarjetaCobro) {
 
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.edad = edad;
        this.hijos = hijos;
        this.tarjetaCobro = tarjetaCobro;
 
        // La composición se inicializa aquí: el Perfil nace con el Soltero
        this.perfil = new Perfil();
 
        // Historial de preferencias vacío al inicio
        this.historialPreferencias = new ArrayList<>();
        this.preferenciaActual = null;
 
        this.story = new ArrayList<>();
        this.fechaCreacion = LocalDate.now();
        this.crush = null;
        this.estadoBusqueda = "single";
    }
 
    // ------------------------------------------------------------------ operaciones de Preferencias
 
    /**
     * Establece o actualiza las preferencias del Soltero.
     * La preferencia anterior pasa al historial antes de ser reemplazada.
     *
     * Esto cumple el punto 3 del enunciado: "Esta descripción puede variar en
     * el tiempo y la agencia debe mantener el histórico."
     */
    public void cambiarPreferencias(Preferencia nuevasPreferencias) {
        if (nuevasPreferencias == null)
            throw new IllegalArgumentException("Las preferencias no pueden ser nulas.");
        if (preferenciaActual != null)
            historialPreferencias.add(preferenciaActual); // archivamos la versión anterior
        preferenciaActual = nuevasPreferencias;
    }
 
    /**
     * Devuelve la preferencia actual (la usada para emparejar).
     */
    public Preferencia getPreferenciaActual() {
        return preferenciaActual;
    }
 
    /**
     * Devuelve las preferencias tal como estaban en una fecha determinada.
     * Busca la versión más reciente que sea anterior o igual a la fecha dada.
     */
    public Preferencia verPreferenciasDate(LocalDate fecha) {
        Preferencia resultado = null;
        for (Preferencia p : historialPreferencias) {
            if (!p.getFecha().isAfter(fecha)) {
                resultado = p;
            }
        }
        // Si no hay ninguna en historial, verificar la actual
        if (resultado == null && preferenciaActual != null
                && !preferenciaActual.getFecha().isAfter(fecha)) {
            resultado = preferenciaActual;
        }
        return resultado;
    }
 
    /**
     * Muestra todas las versiones de preferencias (historial + actual).
     */
    public void verPreferencias() {
        System.out.println("=== Historial de preferencias de " + nombreCompleto + " ===");
        for (int i = 0; i < historialPreferencias.size(); i++) {
            System.out.println("  [" + i + "] " + historialPreferencias.get(i));
        }
        System.out.println("  [actual] " + preferenciaActual);
    }
 
    // ------------------------------------------------------------------ operaciones personales
 
    /**
     * Permite al Soltero modificar sus datos personales y/o perfil.
     * Los parámetros nulos se ignoran (no se sobreescriben).
     */
    public void modificarDatos(String nuevoEmail, String nuevaDireccion, String nuevoDomicilio) {
        if (nuevoEmail != null && !nuevoEmail.isBlank()) this.email = nuevoEmail;
        if (nuevaDireccion != null && !nuevaDireccion.isBlank()) this.direccion = nuevaDireccion;
        if (nuevoDomicilio != null && !nuevoDomicilio.isBlank()) this.domicilio = nuevoDomicilio;
    }
 
    /**
     * Video chat con otro Soltero (punto 5 del enunciado).
     * La lógica de conexión se delega a la capa de infraestructura; aquí se modela la intención.
     */
    public void videoChat(Soltero soltero) {
        if (soltero == null)
            throw new IllegalArgumentException("El soltero destino no puede ser nulo.");
        System.out.println(this.nombreCompleto + " inicia video chat con " + soltero.getNombreCompleto());
        // Aquí se integraría el servicio de WebRTC / videollamada
    }
 
    /**
     * Da de baja al Soltero del sistema (punto 17).
     */
    public void darDeBaja() {
        this.estadoBusqueda = "baja";
        System.out.println("Soltero " + nombreCompleto + " dado de baja del sistema.");
    }
 
    // ------------------------------------------------------------------ gestión del crush
 
    /**
     * Asigna el crush cuando se produce un Match exitoso (punto 10).
     * También marca al Soltero como "matched".
     */
    public void setCrush(Soltero pareja) {
        this.crush = pareja;
        this.estadoBusqueda = "matched";
    }
 
    /**
     * Elimina el crush actual y habilita al Soltero para nuevas búsquedas (punto 15).
     */
    public void bajaCrush() {
        this.crush = null;
        this.estadoBusqueda = "single";
        System.out.println(nombreCompleto + ": crush eliminado. Habilitado para nuevas búsquedas.");
    }
 
    // ------------------------------------------------------------------ getters / setters básicos
 
    public Perfil getPerfil() { return perfil; }
 
    public List<Preferencia> getHistorialPreferencias() {
        return new ArrayList<>(historialPreferencias); // copia defensiva
    }
 
    public String getNombreCompleto() { return nombreCompleto; }
    public String getDni() { return dni; }
    public String getEmail() { return email; }
    public String getDomicilio() { return domicilio; }
    public String getDireccion() { return direccion; }
    public String getEstadoCivil() { return estadoCivil; }
    public String getSexo() { return sexo; }
    public int getEdad() { return edad; }
    public boolean tieneHijos() { return hijos; }
    public Soltero getCrush() { return crush; }
    public Tarjeta getTarjetaCobro() { return tarjetaCobro; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public String getEstadoBusqueda() { return estadoBusqueda; }
    public List<StoryMatch> getStory() { return new ArrayList<>(story); }
 
    public void setEstadoBusqueda(String estado) { this.estadoBusqueda = estado; }
    public void agregarStoryMatch(StoryMatch sm) { this.story.add(sm); }
 
    // ------------------------------------------------------------------ utilidad
 
    @Override
    public String toString() {
        return "Soltero{" +
                "nombre='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", estadoBusqueda='" + estadoBusqueda + '\'' +
                ", crush=" + (crush != null ? crush.getNombreCompleto() : "null") +
                '}';
    }
}
