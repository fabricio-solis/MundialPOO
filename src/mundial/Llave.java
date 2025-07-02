package mundial;

import java.util.ArrayList;

public class Llave extends EtapaMundial {
    private String nombre;
    private ArrayList<Equipo> clasificados;

    public Llave(String nombre) {
        super();
        this.nombre = nombre;
        this.clasificados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Equipo> getClasificados() {
        return clasificados;
    }

    // metodo para jugar los partidos y clasificar ganadores
    public void jugarLlave() {
        for (Partido p : partidos) {
            Resultado r = p.getResultado();
            int ganador = r.obtenerGanador();

            if (ganador == 1) {
                clasificados.add(p.getEquipo1());
            } else if (ganador == 2) {
                clasificados.add(p.getEquipo2());
            } else {
                // Por si hay empate, decidimos con más goles (puede mejorarse)
                clasificados.add(p.getEquipo1()); // decisión arbitraria (se puede mejorar con penales, etc.)
            }
        }
    }

    // metodo polimórfico
    @Override
    public void mostrarResultados() {
        System.out.println("Resultados de la llave: " + nombre);
        for (Partido p : partidos) {
            p.mostrarPartido();
        }

        System.out.println("\nEquipos clasificados:");
        for (Equipo e : clasificados) {
            System.out.println("- " + e.getNombre());
        }
    }
}

