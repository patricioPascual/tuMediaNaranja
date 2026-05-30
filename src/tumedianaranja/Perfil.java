package tumedianaranja;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Perfil {

    private Double estatura;
    private Double peso;
    private int edad;
    private String colorOjos;
    private String colorPelo;
    private String[] nivelCultural;
    private String[] nivelCarinio;
    private String[] companierismo;
    private String[] alegre;
    private String[] salidor;
    private ArrayList<String> aficiones;
    private File fotoPerfil;

    public Perfil(Double estatura, Double peso, String colorOjos, String colorPelo, String[] nivelCultural, String[] nivelCarinio, String[] companierismo, String[] alegre, String[] salidor, ArrayList<String> aficiones) {
        this.estatura = estatura;
        this.peso = peso;
        this.colorOjos = colorOjos;
        this.colorPelo = colorPelo;
        this.nivelCultural = nivelCultural;
        this.nivelCarinio = nivelCarinio;
        this.companierismo = companierismo;
        this.alegre = alegre;
        this.salidor = salidor;
        this.aficiones = aficiones;
    }

    public static Perfil crearPerfil() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese estatura (ej: 1.75): ");
        Double estatura = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("Ingrese peso (ej: 70.5): ");
        Double peso = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("Ingrese color de ojos: ");
        String colorOjos = teclado.nextLine();

        System.out.print("Ingrese color de pelo: ");
        String colorPelo = teclado.nextLine();

        System.out.print("Ingrese nivel cultural (bajo/medio/alto): ");
        String[] nivelCultural = new String[]{teclado.nextLine().toLowerCase()};

        System.out.print("Ingrese nivel de carino (bajo/medio/alto): ");
        String[] nivelCarinio = new String[]{teclado.nextLine().toLowerCase()};

        System.out.print("Ingrese nivel de companerismo (bajo/medio/alto): ");
        String[] companierismo = new String[]{teclado.nextLine().toLowerCase()};

        System.out.print("Ingrese nivel de alegria [alegre] (bajo/medio/alto): ");
        String[] alegre = new String[]{teclado.nextLine().toLowerCase()};

        System.out.print("Ingrese nivel de salida [salidor] (bajo/medio/alto): ");
        String[] salidor = new String[]{teclado.nextLine().toLowerCase()};

        ArrayList<String> aficiones = new ArrayList<>();
        boolean salirAficion = false;

        while (salirAficion) {
            System.out.print("Ingrese una aficion para el perfil: ");
            aficiones.add(teclado.nextLine());

            System.out.println("Â¿Desea agregar otra aficion al perfil? (si/no)");
            String aficionOpcion = teclado.nextLine();

            if (aficionOpcion.equalsIgnoreCase("no")) {
                salirAficion = true;
            }
        }

        return new Perfil(estatura, peso, colorOjos, colorPelo, nivelCultural, nivelCarinio, companierismo, alegre, salidor, aficiones);
    }
}
