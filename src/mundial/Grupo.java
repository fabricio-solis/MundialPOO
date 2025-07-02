package mundial;

import java.util.ArrayList;

public class Grupo extends EtapaMundial {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Grupo(String nombre, ArrayList<Equipo> equipos) {
        super();
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    // metodo para mostrar resultados (polimórfico)
    @Override
    public void mostrarResultados() {
        System.out.println("Resultados del Grupo " + nombre + ":");
        for (Partido p : partidos) {
            p.mostrarPartido();
        }

        System.out.println("\nTabla de posiciones:");
        for (Equipo e : equipos) {
            e.mostrarEstadisticas();
        }
    }

    // Ordenar los equipos por puntos (de mayor a menor)
    public ArrayList<Equipo> clasificarDosEquipos() {
        equipos.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
        ArrayList<Equipo> clasificados = new ArrayList<>();
        clasificados.add(equipos.get(0));
        clasificados.add(equipos.get(1));
        return clasificados;
    }
}
