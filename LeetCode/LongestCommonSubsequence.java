/*
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * - For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class LongestCommonSubsequence {
    public int solution(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Crear una matriz dp de tamaño (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Llenar la matriz dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Si los caracteres coinciden, sumamos 1 al resultado anterior
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Si no coinciden, tomamos el máximo de las dos opciones
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // El resultado es dp[m][n]
        return dp[m][n];
    }
}