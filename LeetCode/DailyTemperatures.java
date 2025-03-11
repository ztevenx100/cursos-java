import java.util.Stack;

/*
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(n), ya que creamos un arreglo de tamaño n + 1.
*/ 

class DailyTemperatures {
    public int[] solution(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // Inicializar el arreglo de respuestas
        Stack<Integer> stack = new Stack<>(); // Pila para almacenar índices de días
        
        // Recorrer el arreglo de temperaturas
        for (int i = 0; i < n; i++) {
            // Mientras la pila no esté vacía y la temperatura actual sea mayor que la del tope de la pila
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Obtener el índice del día anterior
                answer[prevIndex] = i - prevIndex; // Calcular el número de días de espera
            }
            stack.push(i); // Agregar el índice del día actual a la pila
        }
        
        return answer;
    }
}