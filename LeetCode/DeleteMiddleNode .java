/*
 * 2095. Delete the Middle Node of a Linked List
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 * - For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
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

class DeleteMiddleNode  {
    public ListNode solution(ListNode head) {
        // Caso especial: si la lista tiene solo un nodo, devolvemos null
        if (head == null || head.next == null) {
            return null;
        }

        // Inicializamos los punteros slow y fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // Para mantener el nodo anterior a slow

        // Recorremos la lista con los punteros slow y fast
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Eliminamos el nodo central
        prev.next = slow.next;

        return head;
    }
}