package servicio;

import controlador.ControladorIncidencias;
import modelo.Incidencia;

import java.io.FileWriter;
import java.io.IOException;

public class ServicioFichero {

    public static void guardarIncidencia(String ruta, Incidencia i) throws IOException {

        FileWriter escritor = new FileWriter(ruta, true);
        try {
            escritor.write(i.formateador());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el FileWriter");
            }
        }
    }
}
