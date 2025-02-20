package pruebas.mercadoLibre;
import java.io.*;

class ToFizzBuzz {
    /*
     * Complete the 'fizzBuzz' function below.
     * The function accepts INTEGER n as parameter.
     */
    public static void result(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ToFizzBuzz.result(n);

        bufferedReader.close();
    }
}