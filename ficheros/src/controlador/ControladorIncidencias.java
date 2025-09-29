package controlador;

import vista.Escaner;

public class ControladorIncidencias {

    public static void inciar(){

        String nombreDelUsuario= Escaner.leerTexto("Nombre del usuario");


            System.out.println("\n=== MENU DE CONTROL DE INCIDENCIAS ===");
            System.out.println("1. Introducir datos");
            System.out.println("2. Buscar indicencia por usuario");
            System.out.println("3. Buscar incidencia por fecha");
    }
}
