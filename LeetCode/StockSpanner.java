import java.util.Stack;

/*
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(n), ya que creamos un arreglo de tamaño n + 1.
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