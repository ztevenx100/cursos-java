import java.util.HashMap;
import java.util.Map;

/*
 * 2352. Equal Row and Column Pairs
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 * 
 * - Complejidad:
 *     - Tiempo: O(n^2), ya que recorremos la matriz dos veces (una para las filas y otra para las columnas).
 *     - Espacio: O(n^2), ya que almacenamos las filas y columnas como cadenas en un mapa.
*/
class EqualRowAndColumnPairs {
    public int solution(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();

        // Paso 1: Convertir filas a cadenas y contar su frecuencia
        for (int i = 0; i < n; i++) {
            StringBuilder rowKey = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowKey.append(grid[i][j]).append(",");
            }
            rowMap.put(rowKey.toString(), rowMap.getOrDefault(rowKey.toString(), 0) + 1);
        }

        // Paso 2: Convertir columnas a cadenas y contar su frecuencia
        for (int j = 0; j < n; j++) {
            StringBuilder colKey = new StringBuilder();
            for (int i = 0; i < n; i++) {
                colKey.append(grid[i][j]).append(",");
            }
            colMap.put(colKey.toString(), colMap.getOrDefault(colKey.toString(), 0) + 1);
        }

        // Paso 3: Calcular el número de pares iguales
        int count = 0;
        for (String key : rowMap.keySet()) {
            if (colMap.containsKey(key)) {
                count += rowMap.get(key) * colMap.get(key);
            }
        }

        return count;
    }
}