/*
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/
class MaxVowels {
    public int solution(String s, int k) {
        // Definir un conjunto de vocales para facilitar la verificación
        String vowels = "aeiouAEIOU";
        
        // Paso 1: Contar las vocales en la ventana inicial
        int maxVowels = 0;
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // Paso 2: Deslizar la ventana a través de la cadena
        for (int i = k; i < s.length(); i++) {
            // Restar 1 si el carácter que sale es una vocal
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowels--;
            }
            // Sumar 1 si el nuevo carácter es una vocal
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
            // Actualizar el máximo número de vocales
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        // Paso 3: Devolver el máximo número de vocales
        return maxVowels;
    }
}