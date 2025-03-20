package HackerRank;

import java.util.Scanner;

/*
 * Java Datatypes
 * Given an input integer, you must determine which primitive data types are capable of properly storing that input.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaDatatypes {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int t = scanner.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < t; i++) {
            // Leer el número como una cadena para manejar números arbitrariamente grandes
            String input = scanner.next();

            try {
                // Convertir la cadena a un número largo
                long n = Long.parseLong(input);

                // Verificar en qué tipos de datos puede ser almacenado
                System.out.println(n + " can be fitted in:");

                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                if (n >= Long.MIN_VALUE && n <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }
            } catch (NumberFormatException e) {
                // Si el número no puede ser convertido a long, no cabe en ningún tipo primitivo
                System.out.println(input + " can't be fitted anywhere.");
            }
        }

        // Cerrar el Scanner
        scanner.close();
    }
}