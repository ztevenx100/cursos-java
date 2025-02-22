/*
 * 1657. Determine if Two Strings Are Close
 * Two strings are considered close if you can attain one from the other using the following operations:
 *  - Operation 1: Swap any two existing characters.
 *    - For example, abcde -> aecdb
 *  - Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 *    - For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class DetermineIfTwoStringsAreClose {
    public boolean solution(String word1, String word2) {
        // Verificar si las longitudes son diferentes
        if (word1.length() != word2.length()) {
            return false;
        }

        // Paso 1: Verificar si ambas cadenas tienen los mismos caracteres
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : word1.toCharArray()) {
            set1.add(c);
        }
        for (char c : word2.toCharArray()) {
            set2.add(c);
        }
        if (!set1.equals(set2)) {
            return false;
        }

        // Paso 2: Verificar si las frecuencias de los caracteres son las mismas
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}