import java.util.PriorityQueue;

/*
 * 2462. Total Cost to Hire K Workers
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 * You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
 * - You will run k sessions and hire exactly one worker in each session.
 * - In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
 *     - For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
 *     - In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
 * - If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
 * - A worker can only be chosen once.
 * Return the total cost to hire exactly k workers.
 * 
 * - Complejidad:
 *     - Tiempo: O(n log n), debido a las operaciones de inserción y eliminación en los Heaps.
 *     - Espacio: O(n), donde n es el número de elementos en los Heaps.
*/ 

class TotalCostToHire {
    public long solution(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0; // Puntero para los primeros trabajadores
        int right = n - 1; // Puntero para los últimos trabajadores
        
        // Llenar los Heaps con los primeros y últimos `candidates` trabajadores
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
            if (left <= right) {
                rightHeap.offer(costs[right--]);
            }
        }
        
        long totalCost = 0;
        
        // Contratar k trabajadores
        for (int i = 0; i < k; i++) {
            // Elegir el trabajador con el menor costo entre leftHeap y rightHeap
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll(); // Contratar desde leftHeap
                if (left <= right) {
                    leftHeap.offer(costs[left++]); // Agregar el siguiente trabajador
                }
            } else {
                totalCost += rightHeap.poll(); // Contratar desde rightHeap
                if (left <= right) {
                    rightHeap.offer(costs[right--]); // Agregar el siguiente trabajador
                }
            }
        }
        
        return totalCost;
    }
}