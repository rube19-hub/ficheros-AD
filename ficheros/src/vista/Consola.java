package vista;

import controlador.ControladorIncidencias;
import modelo.Incidencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consola {
    private static List<Incidencia> incidencias = new ArrayList<>();

    public static void primerPedir(String nombreDelUsuario) throws IOException {
        int opcion;
        mostrarMenu();

            opcion = Escaner.leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> ControladorIncidencias.introducirValidarDatos(nombreDelUsuario);
                case 2 -> buscarPorUsuario();
                case 3 -> buscarPorFecha();
                default -> System.out.println("Opción no válida.");
            }
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

