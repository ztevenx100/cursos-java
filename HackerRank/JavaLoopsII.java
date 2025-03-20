package HackerRank;

import java.util.Scanner;

/*
 * Java Loops II
 * We use the integers a, b, and n to create the following series:
 * (a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ..., (a + 2^0 * b + 2^1 * b + ... + 2^(n - 1) * b)
 * You are given q queries in the form of a, b, and n. For each query, print the series corresponding to the given a, b, and n values as a single line of n space-separated integers.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaLoopsII {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);

        // Leer el número de consultas
        int q = scanner.nextInt();

        // Procesar cada consulta
        for (int i = 0; i < q; i++) {
            // Leer los valores de a, b y n
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

            // Calcular e imprimir la serie
            int term = a; // Inicializar el término con a
            for (int j = 0; j < n; j++) {
                term += Math.pow(2, j) * b; // Calcular el siguiente término
                System.out.print(term + " "); // Imprimir el término
            }
            System.out.println(); // Salto de línea después de cada consulta
        }

        // Cerrar el Scanner
        scanner.close();
    }
}