/*
 * 746. Min Cost Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class MinCostClimbingStairs {
    public int solution(int[] cost) {
        int n = cost.length;
        
        // Caso base: si no hay escalones, el costo es 0
        if (n == 0) {
            return 0;
        }
        
        // Variables para almacenar los últimos dos valores de dp
        int prev1 = cost[0]; // dp[i-1]
        int prev2 = cost[1]; // dp[i-2]
        
        // Calcular los costos mínimos para cada escalón
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = current;
        }
        
        // El costo mínimo para llegar al tope es el mínimo entre los últimos dos escalones
        return Math.min(prev1, prev2);
    }
}