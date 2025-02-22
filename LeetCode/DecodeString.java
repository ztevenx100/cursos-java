import java.util.Stack;

/*
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 10^5.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es la longitud de la cadena decodificada.
 *     - Espacio: O(n), ya que en el peor caso la pila puede contener todos los caracteres de la cadena.
*/ 
class DecodeString {
    public String solution(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        // Paso 1: Recorrer la cadena
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Paso 2: Manejar dígitos
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Paso 3: Manejar corchetes de apertura
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Paso 4: Manejar corchetes de cierre
                StringBuilder decodedString = stringStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Paso 5: Manejar caracteres normales
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}