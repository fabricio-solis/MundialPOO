package mundial;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private int puntos;
    private ArrayList<Partido> partidosJugados;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.partidosJugados = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Partido> getPartidosJugados() {
        return partidosJugados;
    }

    // metodo para agregar un partido a la lista
    public void agregarPartido(Partido partido) {
        partidosJugados.add(partido);
    }

    // metodo polimórfico (se puede sobrescribir si hereda)
    public void mostrarEstadisticas() {
        System.out.println(nombre + " - Puntos: " + puntos);
    }
}
