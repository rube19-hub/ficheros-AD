package vista;

import modelo.Incidencia;

import java.util.ArrayList;
import java.util.List;

import static controlador.ControladorIncidencias.introducirDatos;

public class Consola {
    private static List<Incidencia> incidencias = new ArrayList<>();

    public static void primerPedir() {
        int opcion;
        mostrarMenu();
        //do {
            opcion = Escaner.leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> introducirDatos();
                case 2 -> buscarPorUsuario();
                case 3 -> buscarPorFecha();
                default -> System.out.println("Opción no válida.");
            }
        //} while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENU DE CONTROL DE INCIDENCIAS ===");
        System.out.println("1. Introducir datos");
        System.out.println("2. Buscar indicencia por usuario");
        System.out.println("3. Buscar incidencia por fecha");
    }

    private static void buscarPorUsuario() {
        String nombreDelUsuario = Escaner.leerTexto("Ingrese el usuario a buscar: ");
        boolean encontrado = false;

        for (Incidencia i : incidencias) {
            if (i.getUsuario().equalsIgnoreCase(nombreDelUsuario)) {
                System.out.println(i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron incidencias para el usuario: " + nombreDelUsuario);
        }
    }

    private static void buscarPorFecha() {
        String fecha = Escaner.leerTexto("Ingrese la fecha de la incidencia a buscar: ");
        boolean encontrado = false;

        for (Incidencia i : incidencias) {
            if (i.getUsuario().equalsIgnoreCase(fecha)) {
                System.out.println(i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron incidencias para esta fecha: " + fecha);
        }
    }
}





    /*private void listarTodas() {
        if (incidencias.isEmpty()) {
            System.out.println("No hay incidencias registradas.");
        } else {
            System.out.println("\n--- Lista de todas las incidencias ---");
            for (Incidencia i : incidencias) {
                System.out.println(i);
            }
        }
    }

    private void registrarIncidencia() {
        String usuario = Escaner.leerTexto("Ingrese usuario: ");
        String fecha = Escaner.leerTexto("Ingrese fecha (dd/mm/yyyy): ");
        String hora = Escaner.leerTexto("Ingrese hora (HH:mm): ");
        String tipo = Escaner.leerTexto("Ingrese tipo de incidencia: ");

        incidencias.add(new Incidencia(usuario, fecha, hora, tipo));
        System.out.println("Incidencia registrada");
    }
*/

