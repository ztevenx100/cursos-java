package pruebas.mercadoLibre;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class ToMergeArrays {

    /*
     * Complete the 'mergeArrays' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> result(List<Integer> a, List<Integer> b) {
        //List<Integer> vectorMasGrande = (a.size() >= b.size())? a: b;
        List<Integer> listaFuncionada = new ArrayList<>();
        int posicionA = 0, posicionB = 0;
        
        while (posicionA < a.size() && posicionB < b.size()) {
            if (a.get(posicionA) < b.get(posicionB)) {
                listaFuncionada.add(a.get(posicionA));
                posicionA++;
            } else {
                listaFuncionada.add(b.get(posicionB));
                posicionB++;
            }
        }
        
        while  (posicionA < a.size()) {
            listaFuncionada.add(a.get(posicionA));
            posicionA++;
        }
        
         while  (posicionB < b.size()) {
            listaFuncionada.add(b.get(posicionB));
            posicionB++;
        }
        
        return listaFuncionada;
    }

}

public class MergeArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ToMergeArrays.result(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
