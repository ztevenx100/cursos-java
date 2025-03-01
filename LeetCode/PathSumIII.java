import java.util.HashMap;
import java.util.Map;

/*
 * 437. Path Sum III
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. Recorremos cada nodo una vez.
 *     - Espacio: O(n), debido al uso del mapa para almacenar las sumas acumuladas.
*/ 

class PathSumIII {
    public int solution(TreeNode root, int targetSum) {
        // Mapa para almacenar las sumas acumuladas y sus frecuencias
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Inicializar con suma acumulada 0
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private static int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        // Calcular la suma acumulada hasta el nodo actual
        currentSum += node.val;

        // Verificar si hay un camino que sume targetSum
        int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Actualizar el mapa con la suma acumulada actual
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recorrer los subárboles izquierdo y derecho
        int result = numPathsToCurr + dfs(node.left, currentSum, targetSum, prefixSumCount)
                                   + dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Restar 1 de la frecuencia de la suma acumulada actual (backtracking)
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
    }
}