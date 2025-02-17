/*
 * 1493. Longest Subarray of 1's After Deleting One Element
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0; // Puntero izquierdo de la ventana
        int maxLength = 0; // Longitud máxima de la ventana
        int zeroCount = 0; // Contador de ceros en la ventana

        // Recorrer el arreglo con el puntero right
        for (int right = 0; right < nums.length; right++) {
            // Si encontramos un cero, incrementamos el contador de ceros
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Si el número de ceros excede 1, movemos el puntero left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--; // Reducimos el contador de ceros
                }
                left++; // Movemos el puntero left
            }

            // Actualizamos la longitud máxima de la ventana
            maxLength = Math.max(maxLength, right - left);
        }

        // Si maxLength es igual a la longitud del arreglo, debemos eliminar un elemento
        return maxLength == nums.length ? maxLength - 1 : maxLength;
    }
}