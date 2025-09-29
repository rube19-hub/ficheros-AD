package repositorio;

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

    public void addDato(String dato){
        //añadir la linea al fichero

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
