package HackerRank;

import java.util.HashMap;
import java.util.Map;

/*
 * Nearly Similar Rectangles
 * Given a list of rectangles where each rectangle is represented by a pair of its sides' lengths, return the number of pairs of rectangles that are nearly similar.
 * Two rectangles are nearly similar if their sides have the same ratio. More formally, two rectangles are nearly similar if the absolute difference between their ratios is less than or equal to 10^-5.
 *
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de rectángulos en la lista.
 *     - Espacio: O(n), donde n es el número de rectángulos en la lista.
*/ 
public class NearlySimilarRectangles {

    public static int nearlySimilarRectangles(int[][] sides) {
        // Map to store the frequency of each ratio
        Map<Double, Integer> ratioFrequency = new HashMap<>();
        
        for (int[] side : sides) {
            double ratio = (double) side[0] / side[1];
            ratioFrequency.put(ratio, ratioFrequency.getOrDefault(ratio, 0) + 1);
        }
        
        int count = 0;
        for (int freq : ratioFrequency.values()) {
            if (freq > 1) {
                // Calculate the number of pairs for each frequency
                count += freq * (freq - 1) / 2;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Sample input
        int[][] sides = {{5, 10}, {10, 10}, {3, 6}, {9, 9}};
        System.out.println(nearlySimilarRectangles(sides)); // Output should be 2
    }
}