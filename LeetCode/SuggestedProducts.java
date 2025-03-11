import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1268. Search Suggestions System
 * You are given an array of strings products and a string searchWord.
 * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 * 
 * - Complejidad:
 *     - Tiempo: O(n * log(n)), ya que ordenamos los productos y realizamos una búsqueda binaria.
 *     - Espacio: O(n), ya que usamos una lista de listas para almacenar las sugerencias.
*/ 
class SuggestedProducts {
    public List<List<String>> solution(String[] products, String searchWord) {
        // Ordenar los productos lexicográficamente
        Arrays.sort(products);
        
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        
        // Recorrer cada carácter de searchWord
        for (char c : searchWord.toCharArray()) {
            prefix.append(c); // Agregar el carácter al prefijo actual
            String currentPrefix = prefix.toString();
            
            // Encontrar el índice del primer producto que comienza con el prefijo actual
            int index = binarySearch(products, currentPrefix);
            
            List<String> suggestions = new ArrayList<>();
            // Recoger hasta 3 productos que coincidan con el prefijo
            for (int i = index; i < Math.min(index + 3, products.length); i++) {
                if (products[i].startsWith(currentPrefix)) {
                    suggestions.add(products[i]);
                } else {
                    break; // No hay más productos con el prefijo
                }
            }
            
            result.add(suggestions); // Agregar la lista de sugerencias al resultado
        }
        
        return result;
    }
    
    // Método para realizar una búsqueda binaria y encontrar el primer producto con el prefijo
    private int binarySearch(String[] products, String prefix) {
        int left = 0;
        int right = products.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}