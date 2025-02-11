/*
 * 334. Increasing Triplet Subsequence
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Inicializamos first y second con el valor máximo posible
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // Recorremos el arreglo
        for (int num : nums) {
            if (num <= first) {
                first = num; // Actualizamos first
            } else if (num <= second) {
                second = num; // Actualizamos second
            } else {
                // Encontramos un tercer número mayor que first y second
                return true;
            }
        }

        // No se encontró una subsecuencia creciente de tres elementos
        return false;
    }
}