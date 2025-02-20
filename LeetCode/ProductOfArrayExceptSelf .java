/*
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo dos veces.
 *     - Espacio: O(1)(excluyendo el arreglo de salida), ya que usamos un solo arreglo answer y una variable suffix.
*/

class ProductOfArrayExceptSelf  {
    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Paso 1: Calcular los productos prefijos
        int[] prefix = new int[n];
        prefix[0] = 1; // No hay elementos a la izquierda del primer elemento
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Paso 2: Calcular los productos sufijos y multiplicarlos con los prefijos
        int suffix = 1; // Inicializamos el sufijo como 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = prefix[i] * suffix; // Multiplicamos prefijo y sufijo
            suffix *= nums[i]; // Actualizamos el sufijo para el siguiente elemento
        }

       return answer;
   }
}