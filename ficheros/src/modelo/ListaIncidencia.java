package modelo;

import java.util.ArrayList;

public class ListaIncidencia {

    private ArrayList<Incidencia> lista;

    public ListaIncidencia(ArrayList<Incidencia> lista) {
        this.lista = lista;
    }

    public ArrayList<Incidencia> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Incidencia> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaIncidencia{" +
                "lista=" + lista +
                '}';
    }
}
