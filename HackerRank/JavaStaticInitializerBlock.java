package HackerRank;

import java.util.Scanner;

/*
 * Java Static Initializer Block
 * You are given a class Solution with a main method. Complete the given code so that it outputs the area of a parallelogram with breadth B and height H. You should read the variables from the standard input.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaStaticInitializerBlock {
    // Declarar variables estáticas
    static int breadth;
    static int height;
    static boolean flag;

    // Bloque de inicialización estática
    static {
        Scanner scanner = new Scanner(System.in);
        breadth = scanner.nextInt(); // Leer el ancho
        height = scanner.nextInt(); // Leer la altura
        scanner.close();

        // Verificar si los valores son válidos
        if (breadth > 0 && height > 0) {
            flag = true; // Los valores son válidos
        } else {
            flag = false; // Los valores no son válidos
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        // Si los valores son válidos, calcular el área
        if (flag) {
            int area = breadth * height;
            System.out.println(area);
        }
    }
}