package controlador;

import modelo.Incidencia;
import vista.Consola;
import vista.Escaner;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


public class ControladorIncidencias {

    static String ruta = "datos/indicencia.txt";

    public static void inciar() throws IOException {

        String nombreDelUsuario = Escaner.leerTexto("Nombre del usuario: ");
        System.out.println("Bienvenido, " + nombreDelUsuario + "!");

        Consola.primerPedir(nombreDelUsuario);

    }

    public static void introducirValidarDatos(String nombreDelUsuario) throws IOException {

        int num = Escaner.leerEntero("Introduce un número: ");

        try {
            if (num == 4) {
                System.out.println("Numero correcto. no hay incidencia");
            } else {

                throw new IOException("Numero no valido");
            }
        } catch (IOException e) {
            String tipo = e.getMessage();
            System.out.println("Error: " + tipo);

            Incidencia incidencia = new Incidencia(
                    LocalDate.now(),
                    LocalTime.now(),
                    tipo,
                    nombreDelUsuario
            );

            escribirIncidencia(ruta, incidencia);
        }
    }

    public static void escribirIncidencia(String ruta, Incidencia i) throws IOException {

        FileWriter escritor = new FileWriter(ruta, true);
        try{
            escritor.write(String.valueOf(i));
            escritor.write("\n");
        }finally {
            escritor.close();
        }
    }
}

