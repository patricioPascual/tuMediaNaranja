package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TuMediaNaranja {

    public Soltero s1;
    public Soltero s2;

    public static void main(String[] args) {
        Soltero s1 = null; // null para que no tire error en prueba
        Soltero s2 = null; // null para que no tire error en prueba

        boolean opcion = true;
        Scanner teclado = new Scanner(System.in);

        while (opcion) { // la flecha que cierra este while la movi abajo de donde pide si quiere ingresar un nuevo usuario porque repetia infinitamente
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
            } else {
                opcion = false; // agregamos este else para que no se repita el bucle
            }
        }

        // AGREGAMOS ESTO EN EL MAIN PARA PROBAR LOS DEMAS METODOS 
        //////
            ///
            ///
            ///
            ///

            if (s1 != null) {
            s2 = new Soltero("Juan Perez", "11222333", "Av. Siempre Viva 742", "juan@email.com", "Soltero", "Masculino", 25, false, null, "juan26", "123456");
        }

        Place lugarFicticio = new Place("Cafetería Central", "urbano");
        Meeting reunionFicticia = new Meeting(LocalDate.now(), 10, "Cita casual", lugarFicticio);

        ArrayList<Meeting> reunionesPrueba = new ArrayList<>();
        reunionesPrueba.add(reunionFicticia);

        Match matchPrueba = new Match(
                LocalDate.now().minusDays(35), // fechaInicio (hace 35 días para forzar la inactividad de 30 días)
                LocalDate.now(), // fechaFin
                s1, // solteroA
                s2, // solteroB
                "PENDIENTE", // resultado
                100, // totalPoints
                reunionFicticia, // meeting (objeto individual)
                reunionesPrueba, // meetings (lista de prueba)
                "Ninguno", // detallesDeFeedback
                "Sin comentarios adicionales" // comentariosAdicionales
        );

        // video chat
        matchPrueba.VideoChat(s1, s2);
        System.out.println("-----------");

        // registrar feedbacks
        Match.registrarFeedbacks(
                "Buena cita", true, "estuvo bien",
                "Copado", true, "quiero repetir"
        );
        System.out.println("-----------");

        // cobro que hicimos en match para la inactividad, los metodos de pago tambien estan en match
        // ponerle saldo alto a los usuarios a la hora de crear para que no tire error
        matchPrueba.comprobacionInactividad(s1, s2);
        System.out.println("-----------");

        // metodo para finalizar match
        matchPrueba.finalizarMatch(s1, s2);
        System.out.println("-----------");

        // listarMeetings
        Match.listarMeetings(reunionesPrueba);
        System.out.println("-----------");

        // metodo ver lugares
        matchPrueba.verLugares(reunionesPrueba);
        System.out.println("-----------");

        // metodos de cobro normal
        s1.setMedioDePago(new MedioDePago("1234-5678-9012-3456", "Juan Perez", LocalDate.now(), "Banco Central", 50000.0, 123));
        s2.setMedioDePago(new MedioDePago("9876-5432-1098-7654", "Clara Gomez", LocalDate.now(), "Banco Galicia", 50000.0, 456));

        // Prueba de cobro normal (Caso sin crush Tarifa 12000)
        s1.setCrush(null);
        matchPrueba.cobrarServicioNormal(s1);

        // Prueba de cobro normal (Caso con crush Tarifa 3000)
        s2.setCrush(s1);
        matchPrueba.cobrarServicioNormal(s2);

    }

}
