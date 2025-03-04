/*
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de ciudades. Recorremos cada ciudad y cada conexión una vez.
 *     - Espacio: O(n), ya que usamos una lista de adyacencia y un arreglo para almacenar las ciudades visitadas.
*/

import java.util.ArrayList;
import java.util.List;

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int solution(int n, int[][] connections) {
        // Crear la lista de adyacencia
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Llenar la lista de adyacencia
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            graph.get(a).add(new int[]{b, 1}); // Arista dirigida de a a b
            graph.get(b).add(new int[]{a, 0}); // Arista no dirigida de b a a
        }

        // Iniciar el recorrido DFS
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }

    private static int dfs(List<List<int[]>> graph, boolean[] visited, int city) {
        visited[city] = true;
        int count = 0;

        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int direction = neighbor[1];

            if (!visited[nextCity]) {
                // Si la arista está orientada en la dirección incorrecta, incrementar el contador
                count += direction;
                count += dfs(graph, visited, nextCity);
            }
        }

        return count;
    }
}