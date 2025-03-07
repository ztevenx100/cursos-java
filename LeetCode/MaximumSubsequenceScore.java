import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 2542. Maximum Subsequence Score
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
 * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
 * The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
 * It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
 * Return the maximum possible score.
 * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/ 

class MaximumSubsequenceScore {
    public long solution(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        // Paso 1: Combinar nums1 y nums2 en una lista de pares (nums2[i], nums1[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums2[i], nums1[i]};
        }
        
        // Paso 2: Ordenar los pares en orden descendente según nums2
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        // Paso 3: Usar un Heap Mínimo para mantener la suma de los k elementos más grandes de nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0; // Suma de los k elementos más grandes de nums1
        long maxScore = 0; // Máxima puntuación
        
        for (int[] pair : pairs) {
            int num2 = pair[0];
            int num1 = pair[1];
            
            // Agregar num1 al Heap y a la suma
            minHeap.offer(num1);
            sum += num1;
            
            // Si el Heap tiene más de k elementos, eliminar el más pequeño
            if (minHeap.size() > k) {
                sum -= minHeap.poll(); // Restar el elemento eliminado de la suma
            }
            
            // Si el Heap tiene exactamente k elementos, calcular la puntuación
            if (minHeap.size() == k) {
                long score = sum * num2; // Suma * mínimo actual (num2)
                maxScore = Math.max(maxScore, score); // Actualizar la máxima puntuación
            }
        }
        
        return maxScore;
    }
}