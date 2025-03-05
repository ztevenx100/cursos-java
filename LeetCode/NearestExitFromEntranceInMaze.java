import java.util.LinkedList;
import java.util.Queue;

/*
 * 1926. Nearest Exit from Entrance in Maze
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 * 
 * - Complejidad:
 *     - Tiempo: O(m⋅n), dondemm es el número de filas y n es el número de columnas en el laberinto. En el peor caso, recorremos todas las celdas.
 *     - Espacio: O(m⋅n), ya que en el peor caso la cola puede contener todas las celdas del laberinto.
*/ 

class NearestExitFromEntranceInMaze {
    public int solution(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        // Direcciones para moverse: arriba, abajo, izquierda, derecha
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Cola para el recorrido BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // [fila, columna, pasos]
        maze[entrance[0]][entrance[1]] = '+'; // Marcar la entrada como visitada

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // Verificar si la celda actual es una salida (y no es la entrada)
            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && !(row == entrance[0] && col == entrance[1])) {
                return steps;
            }

            // Explorar las celdas vecinas
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Verificar si la nueva celda es válida y no ha sido visitada
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                    maze[newRow][newCol] = '+'; // Marcar como visitada
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        // Si no se encontró ninguna salida
        return -1;
    }
}