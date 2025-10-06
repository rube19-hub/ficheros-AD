package controlador;

import vista.Consola;
import vista.Escaner;

public class ControladorIncidencias {

    public static void inciar(){

        String nombreDelUsuario= Escaner.leerTexto("Nombre del usuario: ");
        System.out.println("Bienvenido, " + nombreDelUsuario + "!" );

        Consola.primerPedir();
    }

    public static void introducirDatos(){

        int dato = Escaner.leerEntero("Introduce un número: ");

    }
}
