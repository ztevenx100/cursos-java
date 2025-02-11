/*
 * 443. String Compression
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * - If the group's length is 1, append the character to s.
 * - Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
*/

class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int write = 0; // Índice para escribir en el arreglo comprimido
        int read = 0;  // Índice para leer el arreglo original

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;

            // Contar la longitud del grupo de caracteres consecutivos
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Escribir el carácter en la posición write
            chars[write++] = currentChar;

            // Si la longitud del grupo es mayor que 1, escribir la longitud
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        // Devolver la nueva longitud del arreglo comprimido
        return write;
    }
}