/*
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0; // Puntero izquierdo
        int right = height.length - 1; // Puntero derecho
        int maxArea = 0; // Variable para almacenar el área máxima

        while (left < right) {
            // Calcular el área actual
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            // Actualizar el área máxima
            maxArea = Math.max(maxArea, area);

            // Mover el puntero que apunta a la línea más corta
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}