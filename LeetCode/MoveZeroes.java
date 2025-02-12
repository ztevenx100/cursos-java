/*
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0; // Puntero para escribir elementos no nulos

        // Paso 1: Mover todos los elementos no nulos al principio
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }

        // Paso 2: Llenar el resto del arreglo con ceros
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }
}