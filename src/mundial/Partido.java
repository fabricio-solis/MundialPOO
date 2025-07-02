package mundial;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private Resultado resultado;

    // Constructor
    public Partido(Equipo equipo1, Equipo equipo2, Resultado resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;

        // Registrar partido en ambos equipos
        equipo1.agregarPartido(this);
        equipo2.agregarPartido(this);

        // Asignar puntos según resultado
        asignarPuntos();
    }

    // Getters
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Resultado getResultado() {
        return resultado;
    }

    // logica para asignar puntos
    private void asignarPuntos() {
        int ganador = resultado.obtenerGanador();
        if (ganador == 1) {
            equipo1.setPuntos(equipo1.getPuntos() + 3);
        } else if (ganador == 2) {
            equipo2.setPuntos(equipo2.getPuntos() + 3);
        } else {
            equipo1.setPuntos(equipo1.getPuntos() + 1);
            equipo2.setPuntos(equipo2.getPuntos() + 1);
        }
    }

    // Mostrar resultado
    public void mostrarPartido() {
        System.out.println(equipo1.getNombre() + " vs " + equipo2.getNombre() + ": " + resultado.mostrarResultado());
    }
}
