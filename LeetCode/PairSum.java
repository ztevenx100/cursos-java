/*
 * 2130. Maximum Twin Sum of a Linked List
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de nodos en la lista. Recorremos la lista dos veces: una para encontrar el centro y otra para invertir la segunda mitad y calcular las sumas.
 *     - Espacio: O(1), ya que solo usamos punteros adicionales constantes.
*/

class PairSum {
    public int solution(ListNode head) {
        // Paso 1: Encontrar el centro de la lista usando dos punteros
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Paso 2: Invertir la segunda mitad de la lista
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Paso 3: Calcular las sumas de los gemelos y encontrar la máxima
        int maxSum = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // La segunda mitad invertida
        while (secondHalf != null) {
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }
}