package HackerRank;

import java.util.Scanner;

/*
 * Java Output Formatting
 * Each line of output must contain the original string, the number, and the formatted number as shown below:
 * - The string must be left-justified using exactly 15 characters.
 * - The number must be right-justified using exactly 3 digits.
 * - The formatted number must be right-justified using exactly 3 digits, with leading zeros.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class OutputFormatting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Imprimir la línea de separación inicial
        System.out.println("================================");

        // Leer cada línea de entrada
        while (scanner.hasNext()) {
            String str = scanner.next(); // Leer la cadena
            int num = scanner.nextInt(); // Leer el entero

            // Formatear y imprimir la salida
            System.out.printf("%-15s%03d%n", str, num);
        }

        // Imprimir la línea de separación final
        System.out.println("================================");

        scanner.close(); // Cerrar el Scanner
    }
}