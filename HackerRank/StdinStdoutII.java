package HackerRank;

import java.util.Scanner;

/*
 * Nearly Similar Rectangles
 * Given a list of rectangles where each rectangle is represented by a pair of its sides' lengths, return the number of pairs of rectangles that are nearly similar.
 * Two rectangles are nearly similar if their sides have the same ratio. More formally, two rectangles are nearly similar if the absolute difference between their ratios is less than or equal to 10^-5.
 *
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de rectángulos en la lista.
 *     - Espacio: O(n), donde n es el número de rectángulos en la lista.
*/ 
public class StdinStdoutII {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Leer el entero
        int integerInput = scanner.nextInt();

        // Leer el double
        double doubleInput = scanner.nextDouble();

        // Consumir el carácter de nueva línea restante después de nextDouble()
        scanner.nextLine();

        // Leer la cadena
        String stringInput = scanner.nextLine();

        // Imprimir los valores en el formato requerido
        System.out.println("String: " + stringInput);
        System.out.println("Double: " + doubleInput);
        System.out.println("Int: " + integerInput);

        // Cerrar el Scanner
        scanner.close();
    }
}