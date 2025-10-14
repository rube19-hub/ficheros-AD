package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Incidencia {

    private String usuario;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipo;

    public Incidencia(LocalDate fecha, LocalTime hora, String tipo, String usuario) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Incidencia(String usuario, String fecha, String hora, String tipo) {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "fecha=" + fecha +
                ", usuario='" + usuario + '\'' +
                ", hora=" + hora +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}


