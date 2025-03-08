import java.util.ArrayList;
import java.util.List;

/*
 * 216. Combination Sum III
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * - Only numbers 1 through 9 are used.
 * - Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * 
 * - Complejidad:
 *     - Tiempo: O(9^k), ya que tenemos 9 opciones para cada número y k números en total.
 *     - Espacio: O(k), donde k es el tamaño de la combinación.
*/ 

class CombinationSum3 {
    public List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Si la combinación actual tiene k números y su suma es igual a target, la agregamos al resultado
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Si la combinación actual tiene más de k números o la suma excede target, retrocedemos
        if (current.size() >= k || target < 0) {
            return;
        }
        
        // Iteramos sobre los números desde start hasta 9
        for (int i = start; i <= 9; i++) {
            current.add(i); // Agregar el número a la combinación actual
            backtrack(k, target - i, i + 1, current, result); // Llamada recursiva
            current.remove(current.size() - 1); // Eliminar el último número (backtrack)
        }
    }
}