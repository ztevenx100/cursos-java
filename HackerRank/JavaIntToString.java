package HackerRank;

import java.util.Scanner;

/*
 * Java Int to String
 * You are given an integer n, you have to convert it into a string.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaIntToString {

    public static void main(String[] args) {
        // Leer la entrada
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Convertir el número entero a una cadena
        String s = Integer.toString(n);

        // Verificar si la conversión fue exitosa
        if (n == Integer.parseInt(s)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
    }
}