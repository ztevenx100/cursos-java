/*
 * 643. Maximum Average Subarray I
 * ou are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez con los dos punteros.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/
class MaximumAverageSubarrayI {
    public double solution(int[] nums, int k) {
        // Paso 1: Calcular la suma inicial de los primeros k elementos
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Paso 2: Inicializar la máxima suma con la suma inicial
        double maxSum = windowSum;

        // Paso 3: Deslizar la ventana a través del arreglo
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // Restar el elemento que sale y sumar el nuevo
            maxSum = Math.max(maxSum, windowSum); // Actualizar la máxima suma
        }

        // Paso 4: Calcular y devolver la máxima media
        return maxSum / k;
    }
}