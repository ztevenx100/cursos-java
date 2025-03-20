package HackerRank;

import java.util.Scanner;

/*
 * Java End-of-file
 * The challenge here is to read n lines of input until you reach EOF, then number and print all n lines of content.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaEndOfFile {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);

        // Inicializar el contador de líneas
        int lineNumber = 1;

        // Leer líneas hasta que se alcance el final del archivo (EOF)
        while (scanner.hasNext()) {
            // Leer la línea actual
            String line = scanner.nextLine();

            // Imprimir el número de línea y el contenido de la línea
            System.out.println(lineNumber + " " + line);

            // Incrementar el contador de líneas
            lineNumber++;
        }

        // Cerrar el Scanner
        scanner.close();
    }
}