import controlador.ControladorIncidencias;
import modelo.Incidencia;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ControladorIncidencias.inciar();

        String cadena ="2025-09-16;14:01;excepcion test 1;usuario1";

        String[] datos=cadena.split(";");
        datos=cadena.split(";");

        System.out.println(Arrays.toString(datos));

        Incidencia fallo = new Incidencia(datos[0],datos[1],datos[2],datos[3]);
    }
}