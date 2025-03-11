/*
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(n), ya que creamos un arreglo de tamaño n + 1.
*/

class CountBits {
    public int[] solution(int n) {
        // Crear un arreglo de tamaño n + 1
        int[] ans = new int[n + 1];
        
        // Inicializar el primer elemento
        ans[0] = 0;
        
        // Calcular el número de 1's para cada i desde 1 hasta n
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + (i % 2);
        }
        
        return ans;
    }
}