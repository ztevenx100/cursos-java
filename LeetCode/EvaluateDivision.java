import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 399. Evaluate Division
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 * 
 * - Complejidad:
 *     - Tiempo: O(q⋅n), dondeqq es el número de consultas ynn es el número de variables. En el peor caso, cada consulta puede requerir un recorrido completo del grafo.
 *     - Espacio: O(n), ya que almacenamos el grafo y el conjunto de nodos visitados.
*/ 

class EvaluateDivision {
    public double[] solution(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Construir el grafo
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            // Agregar la relación a / b = value
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, value);

            // Agregar la relación b / a = 1 / value
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1.0 / value);
        }

        // Evaluar las consultas
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                // Si alguna de las variables no está en el grafo, el resultado es -1.0
                results[i] = -1.0;
            } else if (c.equals(d)) {
                // Si las variables son iguales, el resultado es 1.0
                results[i] = 1.0;
            } else {
                // Realizar un DFS para encontrar la relación entre c y d
                results[i] = dfs(graph, c, d, new HashSet<>());
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start); // Marcar la variable como visitada

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            String next = neighbor.getKey();
            double value = neighbor.getValue();

            if (!visited.contains(next)) {
                double result = dfs(graph, next, end, visited);
                if (result != -1.0) {
                    return value * result;
                }
            }
        }

        return -1.0;
    }
}