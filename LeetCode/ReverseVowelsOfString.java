/*
 * 345. Reverse Vowels of a String
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        // Convertimos la cadena en un arreglo de caracteres para facilitar la manipulación
        char[] characters = s.toCharArray();
        
        // Creamos una lista para almacenar las vocales en el orden en que aparecen
        List<Character> vowelsInString = new ArrayList<>();
        
        // Recorremos la cadena para encontrar las vocales
        for (char c : characters) {
            if (vowels.contains(c)) {
                vowelsInString.add(c);
            }
        }
        
        // Invertimos la lista de vocales
        Collections.reverse(vowelsInString);
        
        // Reemplazamos las vocales en la cadena original con las vocales invertidas
        int vowelIndex = 0;
        for (int i = 0; i < characters.length; i++) {
            if (vowels.contains(characters[i])) {
                characters[i] = vowelsInString.get(vowelIndex++);
            }
        }
        
        // Convertimos el arreglo de caracteres de nuevo a una cadena
        return new String(characters);
    }
}