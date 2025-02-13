/*
 * 1679. Max Number of K-Sum Pairs
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
*/

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        // Paso 1: Ordenar el arreglo
        Arrays.sort(nums);

        int left = 0; // Puntero izquierdo
        int right = nums.length - 1; // Puntero derecho
        int operations = 0; // Contador de operaciones

        // Paso 2: Buscar pares que sumen k
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                operations++; // Incrementar el contador de operaciones
                left++; // Mover el puntero izquierdo
                right--; // Mover el puntero derecho
            } else if (sum < k) {
                left++; // Mover el puntero izquierdo
            } else {
                right--; // Mover el puntero derecho
            }
        }

        // Paso 3: Devolver el número de operaciones
        return operations;
    }
}