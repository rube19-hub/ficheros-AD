package repositorio;

import modelo.Incidencia;
import modelo.ListaIncidencia;
import vista.Escaner;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public static List<Incidencia> buscarUsuario() {

        String usuarioParaBuscar = Escaner.leerTexto("Escribe que usuario quieres buscar: ");
        Fichero fichero = new Fichero("datos/indicencia.txt");

        List<String> leido = fichero.leerFichero();

        List<Incidencia> incidenciasEncontradas = new ArrayList<>();

        for (String linea : leido) {

            String[] partes = linea.split(";");

            String fechaEnTexto = partes[0];
            String horaEnTexto = partes[1];
            String tipo = partes[2];
            String usuario = partes[3];

            if (usuarioParaBuscar.equals(usuario)) {
                try {
                    // convertir string a LocalDate y LocalTime

                    LocalDate fecha = LocalDate.parse(fechaEnTexto);
                    LocalTime hora = LocalTime.parse(horaEnTexto);

                    Incidencia nuevaIncidencia = new Incidencia(fecha, hora, tipo, usuario);

                    incidenciasEncontradas.add(nuevaIncidencia);

                } catch (Exception e) {
                    System.out.println("Error al procesar la línea: " + linea);
                }
            }
        }
        if (incidenciasEncontradas.isEmpty()) {
            System.out.println("Este usuario no tiene incidencia");
        }
        System.out.println(incidenciasEncontradas);
        return incidenciasEncontradas;
    }

    public static List<Incidencia> buscarPorFecha() {

        String fechaParaBuscar = Escaner.leerTexto("Escribe la fecha que quieres buscar: ");
        Fichero fichero = new Fichero("datos/indicencia.txt");
        List<String> leido = fichero.leerFichero();

        List<Incidencia> incidenciasEncontradas = new ArrayList<>();

        for (String linea : leido) {

            String[] partes = linea.split(";");

            String fechaEnTexto = partes[0];
            String horaEnTexto = partes[1];
            String tipo = partes[2];
            String usuario = partes[3];

            if (fechaParaBuscar.equals(fechaEnTexto)) {

                try {
                    // Convertir el string a localdate y localtime
                    LocalDate fecha = LocalDate.parse(fechaEnTexto);
                    LocalTime hora = LocalTime.parse(horaEnTexto);

                    Incidencia nuevaIncidencia = new Incidencia(fecha, hora, tipo, usuario);

                    incidenciasEncontradas.add(nuevaIncidencia);

                } catch (Exception e) {
                    System.out.println("Error al procesar la línea: " + linea);
                }
            }
        }
        if (incidenciasEncontradas.isEmpty()) {
            System.out.println("Este usuario no tiene incidencia");
        }
        System.out.println(incidenciasEncontradas);
        return incidenciasEncontradas;
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
