/*
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * 
 * - Complejidad:
 *     - Tiempo: O(n * log(max(piles))), donde n es el tamaño de piles y max(piles) es el máximo valor en piles.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class MinEatingSpeed {
    public int solution(int[] piles, int h) {
        int left = 1; // Velocidad mínima
        int right = getMaxPile(piles); // Velocidad máxima
        
        while (left < right) {
            int mid = left + (right - left) / 2; // Evitar desbordamiento
            
            if (canEatAll(piles, mid, h)) {
                // Koko puede comer todas las bananas con velocidad mid
                // Intentamos reducir la velocidad
                right = mid;
            } else {
                // Koko no puede comer todas las bananas con velocidad mid
                // Aumentamos la velocidad
                left = mid + 1;
            }
        }
        
        // Cuando left == right, hemos encontrado la velocidad mínima
        return left;
    }
    
    // Función para obtener el máximo valor en piles
    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }
    
    // Función para verificar si Koko puede comer todas las bananas con velocidad k en h horas
    private boolean canEatAll(int[] piles, int k, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            // Calculamos las horas necesarias para comer esta pila
            totalHours += (pile + k - 1) / k; // Equivalente a ceil(pile / k)
        }
        return totalHours <= h;
    }
}