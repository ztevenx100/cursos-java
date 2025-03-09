/*
 * 790. Domino and Tromino Tiling
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
 * Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
 * In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el valor de n.
 *     - Espacio: O(n), ya que usamos un arreglo de tamaño n.
*/

class DominoAndTrominoTiling {
    public int solution(int n) {
        int MOD = 1000000007; // Módulo para evitar desbordamiento
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        // Calcular los valores de dp
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        
        return (int) dp[n];
    }
}