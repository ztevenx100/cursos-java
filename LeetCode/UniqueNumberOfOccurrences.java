import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una vez para contar las frecuencias y luego verificamos la unicidad en tiempo constante.
 *     - Espacio: O(1), ya que almacenamos las frecuencias en un mapa y un conjunto.
*/
class UniqueNumberOfOccurrences {
    public boolean solution(int[] arr) {
        // Paso 1: Contar las ocurrencias de cada número
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Paso 2: Verificar si las frecuencias son únicas
        HashSet<Integer> frequencySet = new HashSet<>(frequencyMap.values());
        return frequencyMap.size() == frequencySet.size();
    }
}