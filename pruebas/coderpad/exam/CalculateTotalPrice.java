package pruebas.coderpad.exam;

import java.util.Arrays;

public class CalculateTotalPrice {
    public static int solution(int[] prices, int discount) {
        if (prices.length == 0) return 0;
        
        // Encontrar el precio más alto
        int maxPrice = Arrays.stream(prices).max().getAsInt();
        
        // Calcular el descuento
        double discountAmount = maxPrice * (discount / 100.0);
        double discountedPrice = maxPrice - discountAmount;
        
        // Calcular el total (sumar todos los precios y restar el descuento)
        double total = Arrays.stream(prices).sum() - maxPrice + discountedPrice;
        
        // Redondear hacia abajo y convertir a int
        return (int) Math.floor(total);
    }
}
