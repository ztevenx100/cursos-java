/*
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class HouseRobber {
    public int solution(int[] nums) {
        int n = nums.length;
        
        // Caso base: si no hay casas, el dinero máximo es 0
        if (n == 0) {
            return 0;
        }
        
        // Caso base: si hay una casa, el dinero máximo es nums[0]
        if (n == 1) {
            return nums[0];
        }
        
        // Variables para almacenar los últimos dos valores de dp
        int prev1 = nums[0]; // dp[i-1]
        int prev2 = Math.max(nums[0], nums[1]); // dp[i-2]
        
        // Calcular los valores de dp para cada casa
        for (int i = 2; i < n; i++) {
            int current = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = current;
        }
        
        // El dinero máximo que se puede robar es prev2
        return prev2;
    }
}