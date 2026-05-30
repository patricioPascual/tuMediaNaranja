/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author patri
 */
public class Soltero extends Usuario {

    private Perfil perfil;
    private ArrayList<Preferencia> preferencias;
    private String nombreCompleto;
    private String dni;
    private String domicilio;
    private String email;
    private String estadoCivil;
    private String sexo;
    private int edad;
    private boolean hijos;
    private Soltero crush;
    private Tarjeta tarjetaCobro;
    private ArrayList<StoryMatch> story;
    private LocalDate fechaCreacion;

    public Soltero(Perfil perfil, ArrayList<Preferencia> preferencias, String nombreCompleto, String dni, String domicilio, String email, String estadoCivil, String sexo, int edad, boolean hijos, Tarjeta tarjetaCobro, String nombre, String password) {
        super(nombre, password);
        Scanner teclado = new Scanner(System.in);
        this.preferencias = new ArrayList<>();
        Preferencia prefes = new Preferencia(teclado);
        this.preferencias.add(prefes);
        this.perfil = perfil;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.edad = edad;
        this.hijos = hijos;
        this.tarjetaCobro = tarjetaCobro;
        this.fechaCreacion = LocalDate.now();

    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Preferencia> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(ArrayList<Preferencia> preferencias) {
        this.preferencias = preferencias;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isHijos() {
        return hijos;
    }

    public void setHijos(boolean hijos) {
        this.hijos = hijos;
    }

    public Soltero getCrush() {
        return crush;
    }

    public void setCrush(Soltero crush) {
        this.crush = crush;
    }

    public Tarjeta getTarjetaCobro() {
        return tarjetaCobro;
    }

    public void setTarjetaCobro(Tarjeta tarjetaCobro) {
        this.tarjetaCobro = tarjetaCobro;
    }

    public ArrayList<StoryMatch> getStory() {
        return story;
    }

    public void setStory(ArrayList<StoryMatch> story) {
        this.story = story;
    }

    public void VideoChat(Soltero soltero1, Soltero soltero2) {

    }

    public void verPreferenciasDate(LocalDate fecha) {
        for (Preferencia aux : preferencias) {
            if (aux.getFecha().equals(fecha)) {
                System.out.println("Las preferecncias para esa fecha : ");
                aux.mostrarPreferencias();
            }
        }
    }

    public String opciones() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("---ELIGE TU OPCION---");
            System.out.println("1. Bajo");
            System.out.println("2. Medio");
            System.out.println("3. Alto");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        return "Bajo";
                        
                    case 2:
                        return "Medio";
                        
                    case 3:
                        return "Alto";
                        
                    default:
                        System.out.println("Opcion no valida");
                }
            } else {
                System.out.println("Ingrese un numero valido!");
                teclado.next();
            }
        } while (opcion < 1 && opcion > 3);
        return "";
    }
}
