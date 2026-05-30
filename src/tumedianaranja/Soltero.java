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
    private MedioDePago medioDePago;
    private ArrayList<Match> story;
    private LocalDate fechaCreacion;

    public Soltero(String nombreCompleto, String dni, String domicilio, String email, String estadoCivil, String sexo, int edad, boolean hijos, MedioDePago medioDePago, String nombre, String password) {
        super(nombre, password);
        this.perfil = Perfil.crearPerfil();
        this.preferencias = new ArrayList<>();
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.edad = edad;
        this.hijos = hijos;
        this.medioDePago = medioDePago;
        this.fechaCreacion = LocalDate.now();
        this.cargarPreferencias();

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

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public ArrayList<Match> getStory() {
        return story;
    }

    public void setStory(ArrayList<Match> story) {
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

    public void cargarPreferencias() {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        ArrayList<String> aficiones = new ArrayList();
        boolean saliraficion = false;
        while (!saliraficion) {
            System.out.println("Ingrese una aficion ");
            String aficion = teclado.nextLine();
            aficiones.add(aficion);
            System.out.println("desea agregar otra?");
            if (teclado.nextLine().equalsIgnoreCase("no")) {
                saliraficion = true;
            }

        }
        Preferencia nueva = new Preferencia(aficiones, LocalDate.now());
    }

}
