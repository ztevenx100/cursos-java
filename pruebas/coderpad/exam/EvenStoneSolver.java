package pruebas.coderpad.exam;

import java.util.List;
import java.util.ArrayList;

public class EvenStoneSolver {
    public static List<Integer> spell(List<Integer> numbers) {
        List<Integer> enchantedNumbers = new ArrayList<>();
        
        // Recorrer la lista en orden inverso
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int number = numbers.get(i);
            // Verificar si el número es par
            if (number % 2 == 0) {
                enchantedNumbers.add(number);
            }
        }
        
        return enchantedNumbers;
    }
}