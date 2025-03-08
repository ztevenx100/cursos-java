/*
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * - -1: Your guess is higher than the number I picked (i.e. num > pick).
 * - 1: Your guess is lower than the number I picked (i.e. num < pick).
 * - 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/
class GuessGame {
    int guess(int num) {
        // Esta función es proporcionada por el sistema.
        // No necesitas implementarla.
        return num;
    }
}

class GuessNumber extends GuessGame{
    public int solution(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Evitar desbordamiento
            int result = guess(mid); // Llamar a la API guess
            
            if (result == 0) {
                return mid; // Hemos encontrado el número
            } else if (result == -1) {
                right = mid - 1; // El número es menor que mid
            } else {
                left = mid + 1; // El número es mayor que mid
            }
        }
        
        return -1; // Nunca se alcanzará si el problema está bien definido
    }
}