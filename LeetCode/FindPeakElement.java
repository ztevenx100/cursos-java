/*
 * 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * 
 * - Complejidad:
 *     - Tiempo: O(log n), ya que usamos búsqueda binaria.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class FindPeakElement {
    public int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2; // Evitar desbordamiento
            
            if (nums[mid] < nums[mid + 1]) {
                // El pico está en la mitad derecha
                left = mid + 1;
            } else {
                // El pico está en la mitad izquierda
                right = mid;
            }
        }
        
        // Cuando left == right, hemos encontrado un pico
        return left;
    }
}