/*
 * 72. Edit Distance
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class EditDistance {
    public int solution(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Usar un arreglo unidimensional para almacenar los valores de dp
        int[] dp = new int[n + 1];
        
        // Inicializar el arreglo dp para el caso base (i = 0)
        for (int j = 0; j <= n; j++) {
            dp[j] = j; // Insertar j caracteres
        }
        
        // Calcular los valores de dp para cada fila
        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; // Almacena el valor de dp[i-1][j-1]
            dp[0] = i; // Eliminar i caracteres
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Almacena el valor de dp[i-1][j]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev; // No se necesita ninguna operación
                } else {
                    dp[j] = 1 + Math.min(temp, Math.min(dp[j - 1], prev)); // Tomar el mínimo de las tres operaciones
                }
                prev = temp; // Actualizar prev para la siguiente iteración
            }
        }
        
        // El resultado es dp[n]
        return dp[n];
    }
}