package pruebas.coderpad;

import java.util.List;

public class RadioactivityPeakCounting {
    public static int countPeaks(List<Double> values) {
        int peakCount = 0;
        
        // No podemos tener picos si hay menos de 3 elementos
        if (values.size() < 3) {
            return 0;
        }
        
        // Iteramos desde el segundo elemento hasta el penúltimo
        for (int i = 1; i < values.size() - 1; i++) {
            double current = values.get(i);
            double previous = values.get(i - 1);
            double next = values.get(i + 1);
            
            // Verificamos si es un pico superior
            if (current - previous >= 5 && current - next >= 5) {
                peakCount++;
            } 
            // Verificamos si es un pico inferior
            else if (previous - current >= 5 && next - current >= 5) {
                peakCount++;
            }
        }
        
        return peakCount;
    }
}
