import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 841. Keys and Rooms
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 * 
 * - Complejidad:
 *     - Tiempo: O(n+k), dondenn es el número de habitaciones y k es el número total de llaves. Recorremos cada habitación y cada llave una vez.
 *     - Espacio: O(n), ya que almacenamos las habitaciones visitadas en un conjunto y usamos una cola para el recorrido BFS.
*/ 

class KeysAndRooms {
    public boolean solution(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>(); // Conjunto para almacenar las habitaciones visitadas
        Queue<Integer> queue = new LinkedList<>(); // Cola para el recorrido BFS

        // Comenzar desde la habitación 0
        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll(); // Obtener la habitación actual
            for (int key : rooms.get(currentRoom)) { // Recorrer las llaves en la habitación actual
                if (!visited.contains(key)) { // Si la habitación no ha sido visitada
                    visited.add(key); // Marcarla como visitada
                    queue.offer(key); // Agregarla a la cola para visitarla
                }
            }
        }

        // Verificar si todas las habitaciones han sido visitadas
        return visited.size() == n;
    }
}