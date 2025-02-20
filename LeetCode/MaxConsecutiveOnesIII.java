/*
 * 1004. Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez con los dos punteros.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/
class LongestOnes {
    public int solution(int[] nums, int k) {
        int left = 0; // Puntero izquierdo de la ventana
        int maxLength = 0; // Longitud máxima de la ventana
        int zeroCount = 0; // Contador de ceros en la ventana

        // Recorrer el arreglo con el puntero right
        for (int right = 0; right < nums.length; right++) {
            // Si encontramos un cero, incrementamos el contador de ceros
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Si el número de ceros excede k, movemos el puntero left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--; // Reducimos el contador de ceros
                }
                left++; // Movemos el puntero left
            }

            // Actualizamos la longitud máxima de la ventana
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}