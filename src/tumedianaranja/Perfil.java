/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Perfil representa la descripción pública de un Soltero.
 *
 * COMPOSICIÓN: Perfil existe únicamente dentro de un Soltero.
 * Es instanciado por Soltero en su constructor y no puede
 * transferirse a otro Soltero ni existir de forma independiente.
 *
 * Los atributos de nivel (nivelCultural, nivelDeCariño, etc.) se modelan
 * como String[] con los valores posibles {"bajo", "medio", "alto"}.
 * El valor seleccionado se guarda en un String separado por convención:
 *   nivelCultural[]  → opciones disponibles
 *   nivelCulturalSel → valor actualmente elegido
 * Esto refleja fielmente el UML y permite validación en el setter.
 */
public class Perfil {

    // --- Medidas físicas ---
    private double estatura;   // en metros, ej: 1.72
    private double peso;       // en kg

    // --- Rasgos físicos ---
    private String colorOjos;
    private String colorPelo;

    // --- Niveles (opciones: "bajo", "medio", "alto") ---
    private static final String[] OPCIONES_NIVEL = {"bajo", "medio", "alto"};

    private String nivelCultural;
    private String nivelDeCariño;
    private String compañerismo;
    private String alegre;
    private String salidor;

    // --- Aficiones ---
    private List<String> aficiones; // lista libre de hobbies / intereses

    // --- Foto de perfil ---
    private File fotoPerfil;

    // ------------------------------------------------------------------ constructor

    /**
     * Constructor vacío: Soltero lo llama desde su propio constructor.
     * Los valores se completan luego con los setters / CargarFotoPerfil.
     */
    public Perfil() {
        this.aficiones = new ArrayList<>();
    }

    /**
     * Constructor completo para cuando se dispone de todos los datos al registrarse.
     */
    public Perfil(double estatura, double peso, String colorOjos, String colorPelo,
                  String nivelCultural, String nivelDeCariño, String compañerismo,
                  String alegre, String salidor, List<String> aficiones) {

        validarNivel(nivelCultural,  "nivelCultural");
        validarNivel(nivelDeCariño,  "nivelDeCariño");
        validarNivel(compañerismo,   "compañerismo");
        validarNivel(alegre,         "alegre");
        validarNivel(salidor,        "salidor");

        this.estatura      = estatura;
        this.peso          = peso;
        this.colorOjos     = colorOjos;
        this.colorPelo     = colorPelo;
        this.nivelCultural = nivelCultural;
        this.nivelDeCariño = nivelDeCariño;
        this.compañerismo  = compañerismo;
        this.alegre        = alegre;
        this.salidor       = salidor;
        this.aficiones     = aficiones != null ? new ArrayList<>(aficiones) : new ArrayList<>();
    }

    // ------------------------------------------------------------------ operaciones

    /**
     * Carga o reemplaza la foto de perfil.
     * @param archivo archivo de imagen (jpg, png, etc.)
     */
    public void cargarFotoPerfil(File archivo) {
        if (archivo == null || !archivo.exists())
            throw new IllegalArgumentException("El archivo de foto no existe o es nulo.");
        this.fotoPerfil = archivo;
    }

    /**
     * Agrega una afición a la lista.
     */
    public void agregarAficion(String aficion) {
        if (aficion != null && !aficion.isBlank())
            aficiones.add(aficion);
    }

    /**
     * Elimina una afición de la lista.
     * @return true si existía y fue eliminada
     */
    public boolean eliminarAficion(String aficion) {
        return aficiones.remove(aficion);
    }

    // ------------------------------------------------------------------ validación interna

    /**
     * Verifica que un nivel sea "bajo", "medio" o "alto".
     * Lanza excepción si el valor no es válido.
     */
    private void validarNivel(String valor, String campo) {
        if (valor == null) return; // se permite null en setters parciales
        for (String opcion : OPCIONES_NIVEL) {
            if (opcion.equalsIgnoreCase(valor)) return;
        }
        throw new IllegalArgumentException(
            "Valor inválido para " + campo + ": '" + valor +
            "'. Opciones: bajo, medio, alto.");
    }

    // ------------------------------------------------------------------ getters / setters

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getColorOjos() { return colorOjos; }
    public void setColorOjos(String colorOjos) { this.colorOjos = colorOjos; }

    public String getColorPelo() { return colorPelo; }
    public void setColorPelo(String colorPelo) { this.colorPelo = colorPelo; }

    public String getNivelCultural() { return nivelCultural; }
    public void setNivelCultural(String valor) {
        validarNivel(valor, "nivelCultural");
        this.nivelCultural = valor;
    }

    public String getNivelDeCariño() { return nivelDeCariño; }
    public void setNivelDeCariño(String valor) {
        validarNivel(valor, "nivelDeCariño");
        this.nivelDeCariño = valor;
    }

    public String getCompañerismo() { return compañerismo; }
    public void setCompañerismo(String valor) {
        validarNivel(valor, "compañerismo");
        this.compañerismo = valor;
    }

    public String getAlegre() { return alegre; }
    public void setAlegre(String valor) {
        validarNivel(valor, "alegre");
        this.alegre = valor;
    }

    public String getSalidor() { return salidor; }
    public void setSalidor(String valor) {
        validarNivel(valor, "salidor");
        this.salidor = valor;
    }

    public List<String> getAficiones() { return new ArrayList<>(aficiones); } // copia defensiva

    public File getFotoPerfil() { return fotoPerfil; }

    public static String[] getOpcionesNivel() { return OPCIONES_NIVEL.clone(); }

    // ------------------------------------------------------------------ utilidad

    @Override
    public String toString() {
        return "Perfil{" +
                "estatura=" + estatura +
                ", peso=" + peso +
                ", colorOjos='" + colorOjos + '\'' +
                ", colorPelo='" + colorPelo + '\'' +
                ", nivelCultural='" + nivelCultural + '\'' +
                ", nivelDeCariño='" + nivelDeCariño + '\'' +
                ", compañerismo='" + compañerismo + '\'' +
                ", alegre='" + alegre + '\'' +
                ", salidor='" + salidor + '\'' +
                ", aficiones=" + aficiones +
                '}';
    }
}
