package vista;

import controlador.ControladorIncidencias;
import repositorio.Fichero;

import java.io.IOException;

public class Consola {

    public static void primerPedir(String nombreDelUsuario) throws IOException {
        int opcion;
        mostrarMenu();

        opcion = Escaner.leerEntero("Elige una opción: ");

        switch (opcion) {
            case 1 -> ControladorIncidencias.introducirValidarDatos(nombreDelUsuario);
            case 2 -> Fichero.buscarUsuario();
            case 3 -> Fichero.buscarPorFecha();
            default -> System.out.println("Opción no válida.");
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENU DE CONTROL DE INCIDENCIAS ===");
        System.out.println("1. Introducir datos");
        System.out.println("2. Buscar indicencia por usuario");
        System.out.println("3. Buscar incidencia por fecha");
    }
}

//consola con IA
