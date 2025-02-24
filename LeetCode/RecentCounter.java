import java.util.LinkedList;
import java.util.Queue;

/*
 * 933. Number of Recent Calls
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 * Implement the RecentCounter class:
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de solicitudes que deben ser eliminadas de la cola. En el peor caso, todas las solicitudes excepto una están fuera del rango.
 *     - Espacio: O(1), donde n es el número de solicitudes en el rango de 3000 milisegundos.
*/ 

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Agregar la nueva solicitud a la cola
        queue.offer(t);

        // Eliminar las solicitudes que están fuera del rango [t - 3000, t]
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Devolver el número de solicitudes en el rango
        return queue.size();
        
    }
}