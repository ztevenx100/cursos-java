package pruebas.mercadoLibre;

import java.util.*;

class TwoSums {

    /*
     * Complete the 'twoSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. List<Integer> A
     *  2. INTEGER K
     */
    public static String result(List<Integer> A, int K) {
        // Crear un HashSet para almacenar los números vistos
        Set<Integer> seenNumbers = new HashSet<>();
        
        // Iterar por cada número en el array
        for (int num : A) {
            // Calcular el complemento necesario para que la suma sea K
            int complement = K - num;
            
            // Verificar si el complemento ya existe en el conjunto
            if (seenNumbers.contains(complement)) {
                return "yes";
            }
            
            // Agregar el número actual al conjunto
            seenNumbers.add(num);
        }
        
        // Si no se encuentra ningún par, retornar "no"
        return "no";
    }
}

public class TheTwoSumProblem {
    public static void main(String[] args) {
        // Ejemplo de prueba
        List<Integer> A = Arrays.asList(1, 3, 7);
        int K = 8;

        String result = TwoSums.result(A, K);
        System.out.println(result); // Debe imprimir "yes"
    }
}
