/*
 * 1318. Minimum Flips to Make a OR b Equal to c
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos los bits de a, b y c.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
*/

class MinFlips {
    public int solution(int a, int b, int c) {
        int flips = 0; // Contador de flips
        
        // Recorrer los bits de a, b y c
        while (a > 0 || b > 0 || c > 0) {
            // Extraer el bit menos significativo de a, b y c
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            
            // Verificar si se necesita un flip
            if (bitC == 1) {
                // Si el bit de c es 1, al menos uno de a o b debe ser 1
                if (bitA == 0 && bitB == 0) {
                    flips++; // Necesitamos un flip
                }
            } else {
                // Si el bit de c es 0, ambos bits de a y b deben ser 0
                if (bitA == 1) {
                    flips++; // Necesitamos un flip en a
                }
                if (bitB == 1) {
                    flips++; // Necesitamos un flip en b
                }
            }
            
            // Desplazar a, b y c un bit a la derecha
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return flips;
    }
}