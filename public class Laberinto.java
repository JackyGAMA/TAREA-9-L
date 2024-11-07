public class Laberinto {
    private static final int FILAS = 14; // Ajusta según la matriz
    private static final int COLUMNAS = 8; // Ajusta según la matriz

    // Representación del laberinto
    private static char[][] laberinto = {
        {'P', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'c', 'c', 'c', 'c', 'c', 'p'},
        {'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p'},
        {'p', 'p', 'c', 'c', 'c', 'p', 'c', 'p'},
        {'p', 'p', 'p', 'p', 'c', 'p', 'c', 's'},
        {'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'c', 'c', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}
    };

    private static boolean resolverLaberinto(int x, int y) {
        // Verificar si llegamos a la salida
        if (x >= 0 && x < FILAS && y >= 0 && y < COLUMNAS && laberinto[x][y] == 's') {
            laberinto[x][y] = 'S'; // Marcar como solución
            return true;
        }

        // Verificar si (x, y) es un camino válido
        if (x >= 0 && x < FILAS && y >= 0 && y < COLUMNAS && (laberinto[x][y] == 'p' || laberinto[x][y] == 'P')) {
            // Marcar el camino actual
            laberinto[x][y] = '.';

            // Moverse en las cuatro direcciones (derecha, abajo, izquierda, arriba)
            if (resolverLaberinto(x, y + 1)) return true;
            if (resolverLaberinto(x + 1, y)) return true;
            if (resolverLaberinto(x, y - 1)) return true;
            if (resolverLaberinto(x - 1, y)) return true;

            // Desmarcar si no se encuentra solución en esta dirección
            laberinto[x][y] = ' ';
        }

        return false;
    }

    private static void imprimirLaberinto() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Asumimos que la posición de inicio es (0, 0)
        if (resolverLaberinto(0, 0)) {
            System.out.println("Solución encontrada:");
        } else {
            System.out.println("No se encontró solución.");
        }
        imprimirLaberinto();
    }
}
