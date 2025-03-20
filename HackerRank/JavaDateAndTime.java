package HackerRank;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/*
 * Java Date and Time
 * You are given a date. You just need to write the method, which returns the day on that date.
 *
 * - Complejidad:
 *     - Tiempo: O(1), ya que no se utiliza memoria adicional.
 *     - Espacio: O(1), ya que no se utiliza memoria adicional.
*/ 
public class JavaDateAndTime {

    public static String findDay(int month, int day, int year) {
        // Crear un objeto LocalDate
        LocalDate date = LocalDate.of(year, month, day);

        // Obtener el día de la semana en mayúsculas
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US).toUpperCase();
    }

    public static void main(String[] args) {
        // Leer la entrada
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt(); // Leer el mes
        int day = scanner.nextInt();   // Leer el día
        int year = scanner.nextInt();  // Leer el año
        scanner.close();

        // Llamar al método findDay e imprimir el resultado
        String dayOfWeek = findDay(month, day, year);
        System.out.println(dayOfWeek);
    }
}