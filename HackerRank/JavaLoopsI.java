package HackerRank;

import java.util.Scanner;

/*
 * Java Loops I
 * Given an integer, N, print its first 10 multiples. Each multiple N x i (where 1 <= i <= 10) should be printed on a new line in the form: N x i = result.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaLoopsI {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);

        // Leer el número entero N
        int N = scanner.nextInt();

        // Imprimir los primeros 10 múltiplos de N
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", N, i, N * i);
        }

        // Cerrar el Scanner
        scanner.close();
    }
}