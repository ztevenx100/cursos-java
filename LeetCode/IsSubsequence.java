/*
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * - Complejidad:
 *     - Tiempo: O(n+m), donde n es la longitud de s y m es la longitud de t. En el peor caso, recorremos ambas cadenas una vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class IsSubsequence {
    public boolean solution(String s, String t) {
        int i = 0; // Puntero para s
        int j = 0; // Puntero para t

        // Recorremos ambas cadenas
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Movemos el puntero de s
            }
            j++; // Siempre movemos el puntero de t
        }

        // Si i alcanzó el final de s, entonces s es una subsecuencia de t
        return i == s.length();
    }
}