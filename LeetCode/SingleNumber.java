/*
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class SingleNumber {
    public int solution(int[] nums) {
        int result = 0;
        
        // Aplicar XOR a todos los elementos del arreglo
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}