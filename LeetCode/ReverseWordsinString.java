/*
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez con los dos punteros.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class ReverseWordsInString {
    public String solution(String s) {
        // Paso 1: Eliminar espacios innecesarios
        s = s.trim(); // Elimina espacios al inicio y al final
        
        // Paso 2: Dividir la cadena en palabras, usando uno o más espacios como delimitador
        String[] words = s.split("\\s+"); // "\\s+" es una expresión regular para uno o más espacios
        
        // Paso 3: Invertir el arreglo de palabras
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Paso 4: Unir las palabras invertidas en una sola cadena, separadas por un espacio
        return String.join(" ", words);
    }
}