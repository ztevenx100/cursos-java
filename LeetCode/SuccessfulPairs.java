import java.util.Arrays;

/*
 * 2300. Successful Pairs of Spells and Potions
 * You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 * 
 * - Complejidad:
 *     - Tiempo: O(n log m), donde n es el tamaño de spells y m es el tamaño de potions.
 *     - Espacio: O(n), donde n es el tamaño de spells.
*/ 

class SuccessfulPairs {
    public int[] solution(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        
        // Paso 1: Ordenar el arreglo de pociones
        Arrays.sort(potions);
        
        // Paso 2: Para cada hechizo, calcular el número de pociones exitosas
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long minPotion = (success + spell - 1) / spell; // Equivalente a ceil(success / spell)
            
            // Búsqueda binaria para encontrar la posición de minPotion
            int left = 0;
            int right = m - 1;
            int pos = m; // Inicializar con m (ninguna poción cumple)
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            pairs[i] = m - pos; // Número de pociones exitosas
        }
        
        return pairs;
    }
}