import java.util.LinkedList;
import java.util.Queue;

/*
 * 994. Rotting Oranges
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell,
 * - 1 representing a fresh orange, or
 * - 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * 
 * - Complejidad:
 *     - Tiempo: O(m * n):Recorremos la matriz una vez para inicializar y luego procesamos cada celda como máximo una vez durante BFS.
 *     - Espacio : O(m * n):La cola puede contener hasta m * n elementos en el peor caso.
*/ 

class RottingOranges {
    public int solution(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Cola para almacenar las coordenadas de las naranjas podridas
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0; // Contador de naranjas frescas

        // Inicializar la cola con las naranjas podridas y contar las frescas
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c}); // Agregar naranjas podridas a la cola
                } else if (grid[r][c] == 1) {
                    freshOranges++; // Contar naranjas frescas
                }
            }
        }

        // Direcciones para moverse en las 4 direcciones posibles
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutesPassed = 0;

        // Procesar la propagación de las naranjas podridas
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size(); // Número de naranjas podridas en este nivel
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Intentar infectar a los vecinos
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Verificar si el vecino está dentro de los límites y es una naranja fresca
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Infectar la naranja
                        freshOranges--; // Reducir el contador de naranjas frescas
                        queue.offer(new int[]{newRow, newCol}); // Agregar la nueva naranja podrida a la cola
                    }
                }
            }
            minutesPassed++; // Incrementar el tiempo transcurrido
        }

        // Si aún quedan naranjas frescas, devolver -1
        return freshOranges == 0 ? minutesPassed : -1;
    }
}