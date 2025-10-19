package controlador;

import modelo.Incidencia;
import vista.Consola;
import vista.Escaner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static servicio.ServicioFichero.guardarIncidencia;


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
            } else if (num > 4){

                throw new IOException("Numero muy grande");
            }else if (num < 4){
                throw new IOException("Numero muy pequeño");
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

            guardarIncidencia(ruta, incidencia);
        }
    }
}

