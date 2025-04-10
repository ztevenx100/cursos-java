package pruebas.coderpad;

public class checkSortedArray {
    public static boolean exists(int[] ints, int k) {
        // Implementación de búsqueda binaria
        int left = 0;
        int right = ints.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (ints[mid] == k) {
                return true;
            } else if (ints[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
