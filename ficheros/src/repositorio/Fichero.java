package repositorio;

import modelo.Incidencia;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public static void escribirIncidencia(String ruta, Incidencia p) {
        File file=null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            file = new File(ruta);
            fos = new FileOutputStream(file, true);

            if (file.length() == 0) {
                // si el fichero está vacío, escribo cabecera normal
                oos = new ObjectOutputStream(fos);
            } else {
                // si ya hay datos, uso la versión sin cabecera
                oos = new MiObjectOutputStream(fos);
            }

            oos.writeObject(p);
            System.out.println("Incidencia guardada: " + p);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null){
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String buscarDato(String dato, int columna){

        return "";
    }

    public String buscarDato(LocalDate fechaInicial, LocalDate fechaFinal){

        return "";
    }

    public ArrayList<String> leerFichero(String dato){

        try{
            FileWriter Fichero = new FileWriter("datos/incidencia.txt");
            Fichero.write(dato);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
