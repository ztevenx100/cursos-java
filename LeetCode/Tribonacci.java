/*
 * 1137. N-th Tribonacci Number
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el valor de n.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class Tribonacci {
    public int solution(int n) {
        // Casos base
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // Variables para almacenar los últimos tres valores
        int a = 0, b = 1, c = 1;
        int result = 0;
        
        // Calcular T(n) usando solo tres variables
        for (int i = 3; i <= n; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        
        return result;
    }
}