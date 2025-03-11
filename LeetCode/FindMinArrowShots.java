import java.util.Arrays;
import java.util.Comparator;

/*
 * 452. Minimum Number of Arrows to Burst Balloons
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * 
 * - Complejidad:
 *     - Tiempo: O(n log n), ya que ordenamos los intervalos por su punto final.
 *     - Espacio: O(1): Usamos espacio adicional constante.
*/ 
class FindMinArrowShots {
    public int solution(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Ordenar los globos por su punto final en orden ascendente
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int arrows = 1; // Contador de flechas
        int end = points[0][1]; // Punto final del último globo seleccionado
        
        // Recorrer los globos restantes
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int currentEnd = points[i][1];
            
            if (start > end) {
                // No hay superposición, necesitamos una nueva flecha
                arrows++;
                end = currentEnd;
            }
            // Si hay superposición, no necesitamos una nueva flecha
        }
        
        return arrows;
    }
}