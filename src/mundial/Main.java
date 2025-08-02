package mundial;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Lista de nombres de equipos (32)
        String[] nombresEquipos = {
                "Argentina", "Brasil", "Francia", "Alemania",
                "España", "Portugal", "Inglaterra", "Países Bajos",
                "Uruguay", "México", "Bélgica", "Croacia",
                "Japón", "Corea del Sur", "Senegal", "Australia",
                "Ecuador", "Qatar", "Irán", "Estados Unidos",
                "Gales", "Polonia", "Marruecos", "Suiza",
                "Serbia", "Dinamarca", "Túnez", "Arabia Saudita",
                "Camerún", "Canadá", "Costa Rica", "Ghana"
        };

        // 2. Crear objetos Equipo
        ArrayList<Equipo> todosLosEquipos = new ArrayList<>();
        for (String nombre : nombresEquipos) {
            todosLosEquipos.add(new Equipo(nombre));
        }

        // 3. Dividir en grupos (8 grupos de 4 equipos)
        ArrayList<Grupo> grupos = new ArrayList<>();
        int grupoActual = 0;
        for (int i = 0; i < todosLosEquipos.size(); i += 4) {
            ArrayList<Equipo> grupoEquipos = new ArrayList<>(todosLosEquipos.subList(i, i + 4));
            Grupo grupo = new Grupo("Grupo " + (char) ('A' + grupoActual), grupoEquipos);
            generarPartidosDeGrupo(grupo); // 6 partidos por grupo
            grupos.add(grupo);
            grupoActual++;
        }

        // 4. Mostrar resultados y clasificados
        ArrayList<Equipo> clasificados = new ArrayList<>();
        for (Grupo grupo : grupos) {
            grupo.mostrarResultados();
            ArrayList<Equipo> top2 = grupo.clasificarDosEquipos();
            clasificados.addAll(top2);
            System.out.println("\nClasificados del " + grupo.getNombre() + ": " +
                    top2.get(0).getNombre() + " y " + top2.get(1).getNombre() + "\n-------------------\n");
        }

        // 5. Octavos de Final
        Llave octavos = new Llave("Octavos de Final");
        octavos.construirLlave(clasificados);
        octavos.jugarLlave();
        octavos.mostrarResultados();

        // 6. Cuartos de Final
        Llave cuartos = new Llave("Cuartos de Final");
        cuartos.construirLlave(octavos.getClasificados());
        cuartos.jugarLlave();
        cuartos.mostrarResultados();

        // 7. Semifinal
        Llave semifinal = new Llave("Semifinal");
        semifinal.construirLlave(cuartos.getClasificados());
        semifinal.jugarLlave();
        semifinal.mostrarResultados();

        // 8. Final
        Llave finalMundial = new Llave("Final del Mundial");
        finalMundial.construirLlave(semifinal.getClasificados());
        finalMundial.jugarLlave();
        finalMundial.mostrarResultados();

        // 9. Campeón
        System.out.println("\n🏆 ¡El campeón del Mundial es: " +
                finalMundial.getClasificados().get(0).getNombre() + "!");
    }

    // Método auxiliar para generar los partidos del grupo (6 combinaciones)
    public static void generarPartidosDeGrupo(Grupo grupo) {
        ArrayList<Equipo> eq = grupo.getEquipos();

        int[][] combinaciones = {
                {0, 1}, {0, 2}, {0, 3},
                {1, 2}, {1, 3},
                {2, 3}
        };

        for (int[] c : combinaciones) {
            Equipo e1 = eq.get(c[0]);
            Equipo e2 = eq.get(c[1]);
            Resultado resultado = new Resultado((int) (Math.random() * 5), (int) (Math.random() * 5));
            Partido partido = new Partido(e1, e2, resultado);
            grupo.agregarPartido(partido);
        }
    }
}
