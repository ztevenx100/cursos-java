/*
 * 1732. Find the Highest Altitude
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
 * Return the highest altitude of a point.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/
class LargestAltitude {
    public int solution(int[] gain) {
        // Inicializamos la altitud actual y la altitud más alta
        int currentAltitude = 0;
        int highestAltitude = 0;

        // Recorremos el arreglo gain
        for (int g : gain) {
            // Actualizamos la altitud actual
            currentAltitude += g;
            // Actualizamos la altitud más alta si es necesario
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }

        // Retornamos la altitud más alta
        return highestAltitude;
    }
}