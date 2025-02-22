import java.util.Stack;

/*
 * 735. Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que cada asteroide se procesa una sola vez.
 *     - Espacio: O(1), ya que en el peor caso la pila puede contener todos los asteroides.
*/ 
class AsteroidCollision {
    public int[] solution(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // Paso 1: Recorrer los asteroides
        for (int asteroid : asteroids) {
            // Paso 2: Manejar colisiones
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.pop();
                if (top > -asteroid) {
                    asteroid = top; // El asteroide en la pila es más grande
                    break;
                } else if (top == -asteroid) {
                    asteroid = 0; // Ambos asteroides explotan
                    break;
                }
                // Si el asteroide en la pila es más pequeño, continuamos verificando colisiones
            }
            if (asteroid != 0) {
                stack.push(asteroid); // Agregar el asteroide a la pila si no ha explotado
            }
        }

        // Paso 3: Convertir la pila en un arreglo de resultados
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}