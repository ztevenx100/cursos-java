/*
 * 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
*/

class Solution {
    public int pivotIndex(int[] nums) {
        // Calculamos la suma total del arreglo
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Inicializamos la suma de los elementos a la izquierda
        int leftSum = 0;

        // Recorremos el arreglo para encontrar el índice pivote
        for (int i = 0; i < nums.length; i++) {
            // Calculamos la suma derecha
            int rightSum = totalSum - leftSum - nums[i];

            // Verificamos si la suma izquierda es igual a la suma derecha
            if (leftSum == rightSum) {
                return i; // Retornamos el índice pivote
            }

            // Actualizamos la suma izquierda para el siguiente índice
            leftSum += nums[i];
        }

        // Si no encontramos ningún índice pivote, retornamos -1
        return -1;
    }
}