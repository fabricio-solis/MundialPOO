package mundial;

public class Resultado {
    private int golesEquipo1;
    private int golesEquipo2;

    // Constructor
    public Resultado(int golesEquipo1, int golesEquipo2) {
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    // Getters
    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    // metodos para determinar el resultado del partido
    public int obtenerGanador() {
        if (golesEquipo1 > golesEquipo2) return 1;
        if (golesEquipo2 > golesEquipo1) return 2;
        return 0; // Empate
    }

    public String mostrarResultado() {
        return golesEquipo1 + " - " + golesEquipo2;
    }
}
