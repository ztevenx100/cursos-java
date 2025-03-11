import java.util.Stack;

/*
 * 901. Online Stock Span
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 * - For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
 * - Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 * Implement the StockSpanner class:
 * - StockSpanner() Initializes the object of the class.
 * - int next(int price) Returns the span of the stock's price given that today's price is price.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(n), ya que usamos una pila para almacenar pares (precio, span).
*/ 

class StockSpanner {
    // Pila para almacenar pares (precio, span)
    private Stack<int[]> stack;

    // Constructor
    public StockSpanner() {
        stack = new Stack<>();
    }

    // Método next
    public int next(int price) {
        int span = 1; // El span mínimo es 1 (el día actual)
        
        // Mientras la pila no esté vacía y el precio en el tope sea menor o igual al precio actual
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Sumar el span del tope de la pila
        }
        
        // Agregar el par (precio, span) a la pila
        stack.push(new int[]{price, span});
        
        return span;
    }
}