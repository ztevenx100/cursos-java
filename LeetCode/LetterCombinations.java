/*
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * - Complejidad:
 *     - Tiempo: O(4^n), donde n es la cantidad de dígitos en el string de entrada. En el peor caso, cada dígito tiene 4 letras asociadas.
 *     - Espacio: O(n), donde n es la cantidad de dígitos en el string de entrada. La recursión puede llegar a tener n llamadas en la pila.
*/

import java.util.ArrayList;
import java.util.List;

class LetterCombinations {
    // Mapeo de dígitos a letras
    private String[] digitToLetters = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> solution(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; // Caso base: si no hay dígitos, devolvemos una lista vacía
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Si la combinación actual tiene la misma longitud que los dígitos, la agregamos al resultado
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Obtenemos las letras correspondientes al dígito actual
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];
        
        // Iteramos sobre las letras y las agregamos a la combinación actual
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Agregar la letra
            backtrack(digits, index + 1, current, result); // Llamada recursiva
            current.deleteCharAt(current.length() - 1); // Eliminar la última letra (backtrack)
        }
    }
}