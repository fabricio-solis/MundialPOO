package mundial;

import java.util.ArrayList;

public abstract class EtapaMundial {
    protected ArrayList<Partido> partidos;

    public EtapaMundial() {
        this.partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    // metodo abstracto que será implementado en las subclases
    public abstract void mostrarResultados();
}
