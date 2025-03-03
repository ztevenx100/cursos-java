/*
 * 547. Number of Provinces
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class NumberOfProvinces {
    public int solution(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; // Arreglo para almacenar las ciudades visitadas
        int provinces = 0; // Contador de provincias

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Iniciar DFS desde la ciudad i
                dfs(isConnected, visited, i);
                provinces++; // Incrementar el contador de provincias
            }
        }

        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true; // Marcar la ciudad como visitada
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                // Si la ciudad vecina está conectada y no ha sido visitada, explorarla
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}