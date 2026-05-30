
package tumedianaranja;

import java.util.Scanner;


public class TuMediaNaranja {

    public Soltero s1;
    public Soltero s2;

    public static void main(String[] args) {
        Soltero s1;
        Soltero s2;

        boolean opcion = false;
        Scanner teclado = new Scanner(System.in);

        while (opcion) {
            System.out.println("Bienvenido Media Naranja");

            System.out.println("Ingrese Usuario");
            String usuario = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese ContraseÃ±a");
            String password = teclado.next();
            teclado.nextLine();

            System.out.println("----------------------------------------------------------");
            System.out.println("Ingrese su Nombre Completo: ");
            String nombreCompleto = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su DNI: ");
            String dni = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su Domicilio: ");
            String domicilio = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su Email: ");
            String email = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su Estado Civil: ");
            String estadoCivil = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su Sexo: ");
            String sexo = teclado.next();
            teclado.nextLine();

            System.out.println("Ingrese su Edad: ");
            int edad = teclado.nextInt();
            teclado.nextLine();

            System.out.println("Tienes Hijos? S/N");
            boolean opcionHijo;
            String opcionHijoLetra = teclado.next();
            teclado.nextLine();
            if (opcionHijoLetra.equalsIgnoreCase("S")) {
                opcionHijo = true;
            } else {
                opcionHijo = false;
            }
            MedioDePago medioDePago = null;

            s1 = new Soltero(nombreCompleto, dni, domicilio, email, estadoCivil, sexo, edad, opcionHijo, medioDePago, usuario, password);

            System.out.println("----------------------------------------------------------");
            System.out.println("Desea ingresar otro Usario?  S/N");
            String opcionLetra = teclado.next();
            teclado.nextLine();

            if (opcionLetra.equalsIgnoreCase("s")) {
                opcion = true;
            } 
        }
    }

}