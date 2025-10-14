package repositorio;

import modelo.Incidencia;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fichero {

    private String ruta;

    public Fichero(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Fichero{" +
                "ruta='" + ruta + '\'' +
                '}';
    }

//    public static void escribirIncidencia(String ruta, Incidencia i) throws IOException {
//
//
//        FileWriter escritor = new FileWriter(ruta);
//        String linea = i.getUsuario() + ";" + i.getTipo() + ";" + i.getFecha() + ";" + i.getHora();
//
//
//        escritor.write(linea);
//
//    }


    /*public static ArrayList<Incidencia> buscarUsuario(String usuario, ListaIncidencia){

        ArrayList<Incidencia> lista =new ListaIncidencia;

        try{
            for(Incidencia item : datos)
        }
        return lista;
    }*/

    public String buscarFecha(LocalDate fechaInicial) {

        return "";
    }


    public List<String> leerFichero() {
        String cadena = "";
        List<String> listaCadenas = new ArrayList<>();

        FileReader fichero = null;
        BufferedReader lector = null;

        try {
            fichero = new FileReader(ruta);
            lector = new BufferedReader(fichero);

            do {
                cadena = lector.readLine();
                if (cadena != null) {
                    listaCadenas.add(cadena);
                }
            } while (cadena != null);

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                } else if (fichero != null) {
                    fichero.close();
                }

            } catch (IOException e) {
                System.out.println("Error al realizar la lectura");
            }
        }

        return listaCadenas;
    }

    public void escribirFichero(String dato) {

        FileWriter fichero = null;

        try {
            fichero = new FileWriter(ruta);
            fichero.write(dato + "\n");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");

        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el FileWriter");
            }
        }
    }
}
