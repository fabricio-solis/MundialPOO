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

    // Metodo Mejorado
    public void construirLlave(ArrayList<Equipo> equiposClasificados) {
        for (int i = 0; i < equiposClasificados.size(); i += 2) {
            Equipo e1 = equiposClasificados.get(i);
            Equipo e2 = equiposClasificados.get(i + 1);
            Resultado resultado = new Resultado((int) (Math.random() * 5), (int) (Math.random() * 5));
            Partido partidoGenerado = new Partido(e1, e2, resultado);
            this.agregarPartido(partidoGenerado);
        }
    }

    public void jugarLlave() {
        for (Partido partido : partidos) {
            Resultado resultado = partido.getResultado();
            int ganador = resultado.obtenerGanador();

            if (ganador == 1) {
                clasificados.add(partido.getEquipo1());
            } else if (ganador == 2) {
                clasificados.add(partido.getEquipo2());
            } else {
                // Si empatan, elegimos arbitrariamente al primero (se puede mejorar)
                clasificados.add(partido.getEquipo1());
            }
        }
    }

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
