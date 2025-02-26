/*
 * 328. Odd Even Linked List
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de nodos en la lista. Recorremos la lista una vez.
 *     - Espacio: O(1), ya que solo usamos punteros adicionales constantes.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class OddEvenList {
    public ListNode solution(ListNode head) {
        // Caso base: si la lista está vacía o tiene un solo nodo
        if (head == null || head.next == null) {
            return head;
        }

        // Inicializar punteros
        ListNode odd = head; // Primer nodo impar
        ListNode even = head.next; // Primer nodo par
        ListNode evenHead = even; // Guardar el inicio de la lista par

        // Iterar mientras haya nodos pares e impares disponibles
        while (even != null && even.next != null) {
            // Conectar el siguiente nodo impar
            odd.next = even.next;
            odd = odd.next;

            // Conectar el siguiente nodo par
            even.next = odd.next;
            even = even.next;
        }

        // Conectar la lista impar con la lista par
        odd.next = evenHead;

        // Devolver la cabeza de la lista reorganizada
        return head;
    }
}