/*
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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

class ReverseList {
    public ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        // Paso 1: Recorrer la lista y revertir los punteros
        while (current != null) {
            ListNode next = current.next; // Guardar el siguiente nodo
            current.next = prev;         // Revertir el puntero
            prev = current;              // Mover prev al nodo actual
            current = next;              // Mover current al siguiente nodo
        }

        // Paso 2: Devolver la nueva cabeza de la lista invertida
        return prev;
    }
}