package HackerRank;

import java.util.Scanner;

/*
 * Java Stdin and Stdout II
 * In this challenge, you must read an integer, a double, and a String from stdin, then print the values according to the instructions provided.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
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