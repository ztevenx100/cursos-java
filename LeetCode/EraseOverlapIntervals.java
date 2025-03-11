import java.util.Arrays;
import java.util.Comparator;

/*
 * 435. Non-overlapping Intervals
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 * 
 * - Complejidad:
 *     - Tiempo: O(n log n), ya que ordenamos los intervalos por su punto final.
 *     - Espacio: O(1), ya que no usamos espacio adicional.
*/ 

class EraseOverlapIntervals {
    public int solution(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        // Ordenar los intervalos por su punto final en orden ascendente
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int count = 0; // Contador de intervalos eliminados
        int end = intervals[0][1]; // Punto final del último intervalo seleccionado
        
        // Recorrer los intervalos restantes
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            if (start >= end) {
                // No hay superposición, seleccionar este intervalo
                end = currentEnd;
            } else {
                // Hay superposición, incrementar el contador
                count++;
            }
        }
        
        return count;
    }
}