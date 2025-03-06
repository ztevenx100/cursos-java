import java.util.Arrays;

/*
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * 
 * - Complejidad:
 *     - Tiempo: O(n log n), debido a la operación de ordenación.
 *     - Espacio: O(1), ya que no usamos espacio adicional.
*/

class KthLargestElement {
    public int solution(int[] nums, int k) {
        Arrays.sort(nums); // Ordena el arreglo en orden ascendente
        return nums[nums.length - k]; // Devuelve el k-ésimo elemento más grande
    }
}