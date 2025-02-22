import java.util.Stack;

/*
 * 2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * - Choose a star in s.
 * - Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 * Note:
 * - The input will be generated such that the operation is always possible.
 * - It can be shown that the resulting string will always be unique.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos la cadena una sola vez.
 *     - Espacio: O(n), ya que en el peor caso la pila puede contener todos los caracteres de la cadena.
*/
class RemovingStarsFromAString {
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();

        // Paso 1: Recorrer la cadena
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Paso 2: Si es una estrella, eliminar el carácter más reciente de la pila
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Paso 3: Si no es una estrella, agregar el carácter a la pila
                stack.push(c);
            }
        }

        // Paso 4: Construir la cadena resultante
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}