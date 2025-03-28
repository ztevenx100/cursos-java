package HackerRank;

import java.util.Scanner;

/*
 * Java If-Else
 * Given an integer, n, perform the following conditional actions:
 * - If n is odd, print Weird
 * - If n is even and in the inclusive range of 2 to 5, print Not Weird
 * - If n is even and in the inclusive range of 6 to 20, print Weird
 * - If n is even and greater than 20, print Not Weird
 *
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de rectángulos en la lista.
 *     - Espacio: O(n), donde n es el número de rectángulos en la lista.
*/ 
public class WeirdOrNot {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        if (N % 2 != 0) {
            System.out.println("Weird");
        } else {
            if (N >= 2 && N <= 5) {
                System.out.println("Not Weird");
            } else if (N >= 6 && N <= 20) {
                System.out.println("Weird");
            } else if (N > 20) {
                System.out.println("Not Weird");
            }
        }
        
        scanner.close();
    }
}