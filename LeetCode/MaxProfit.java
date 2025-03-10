/*
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * Note:
 * - You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * - The transaction fee is only charged once for each stock purchase and sale.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de días. Recorremos todos los días una vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class MaxProfit {
    public int solution(int[] prices, int fee) {
        int n = prices.length;
        
        // Inicializar los estados
        int cash = 0; // Beneficio máximo sin acciones al final del día
        int hold = -prices[0]; // Beneficio máximo con acciones al final del día
        
        // Calcular los estados para cada día
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Vender la acción
            hold = Math.max(hold, cash - prices[i]); // Comprar una acción
        }
        
        // El beneficio máximo es cash
        return cash;
    }
}