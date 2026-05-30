
package tumedianaranja;
/*
 * Criterio representa un atributo de preferencia con su valor deseado
 * y el nivel de importancia (ponderación) que le asigna el Soltero.
 *
 * Ejemplos de uso:
 *   new Criterio("colorPelo", "rubio", 4)
 *   new Criterio("nivelCultural", "alto", 5)
 *   new Criterio("hijos", false, 2)
 *
 * valorDeseado es Object para soportar cualquier tipo:
 * String, Integer, Boolean, Double, etc.
 */
public class Criterio {

    private String nombre;       // nombre del atributo preferido (ej: "colorPelo")
    private Object valorDeseado; // valor esperado para ese atributo (polimórfico)
    private int ponderacion;     // importancia del criterio: 1 (mínimo) a 5 (imprescindible)

    // ------------------------------------------------------------------ constructor

    /**
     * @param nombre       identificador del criterio (no nulo ni vacío)
     * @param valorDeseado valor esperado; puede ser String, Integer, Boolean, Double…
     * @param ponderacion  entre 1 y 5 inclusive
     */
    public Criterio(String nombre, Object valorDeseado, int ponderacion) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del criterio no puede ser nulo o vacío.");
        if (ponderacion < 1 || ponderacion > 5)
            throw new IllegalArgumentException("La ponderación debe estar entre 1 y 5.");

        this.nombre = nombre;
        this.valorDeseado = valorDeseado;
        this.ponderacion = ponderacion;
    }

    // ------------------------------------------------------------------ operaciones

    /**
     * Actualiza la ponderación del criterio.
     * @param nuevaPonderacion valor entre 1 y 5
     */
    public void cambiarPonderacion(int nuevaPonderacion) {
        if (nuevaPonderacion < 1 || nuevaPonderacion > 5)
            throw new IllegalArgumentException("La ponderación debe estar entre 1 y 5.");
        this.ponderacion = nuevaPonderacion;
    }

    // ------------------------------------------------------------------ getters / setters

    public String getNombre() { return nombre; }

    public Object getValorDeseado() { return valorDeseado; }
    public void setValorDeseado(Object valorDeseado) { this.valorDeseado = valorDeseado; }

    public int getPonderacion() { return ponderacion; }

    // ------------------------------------------------------------------ utilidad

    @Override
    public String toString() {
        return "Criterio{" +
                "nombre='" + nombre + '\'' +
                ", valorDeseado=" + valorDeseado +
                ", ponderacion=" + ponderacion +
                '}';
    }
}