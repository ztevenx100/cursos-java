import java.util.PriorityQueue;

/*
 * 2336. Smallest Number in Infinite Set
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * Implement the SmallestInfiniteSet class:
 * - SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * - int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * - void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 * 
 * - Complejidad:
 *     - popSmallest():
 *         - Tiempo: O(log n) si el Heap no está vacío (debido a la operación poll).
 *         - Tiempo: O(1) si el Heap está vacío.
 *     - addBack(num):
 *         - Tiempo: O(log n) (debido a la operación offer).
 *         - Espacio: O(n), donde n es el número de elementos en el Heap.
*/ 

class SmallestInfiniteSet {
    private PriorityQueue<Integer> heap; // Heap para almacenar números agregados de vuelta
    private int next; // Contador para la secuencia infinita

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        next = 1; // Inicializamos el contador en 1
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll(); // Si hay números en el heap, devolvemos el más pequeño
        }
        return next++; // Si no, devolvemos el siguiente número en la secuencia
    }

    public void addBack(int num) {
        if (num < next && !heap.contains(num)) {
            heap.offer(num); // Agregamos el número al heap si es menor que next y no está en el heap
        }
    }
}