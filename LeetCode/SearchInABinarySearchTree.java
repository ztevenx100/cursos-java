/*
 * 700. Search in a Binary Search Tree
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * 
 * - Complejidad:
 *     - Tiempo: O(h), donde h es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=logn.
 *     - Espacio: O(h), debido a la recursión. En el peor caso, la pila de llamadas recursivas puede tener una profundidad de h.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SearchInABinarySearchTree {
    public TreeNode solution(TreeNode root, int val) {
        // Caso base: si el nodo es null, devolvemos null
        if (root == null) {
            return null;
        }

        // Si el valor del nodo actual es igual a val, devolvemos el nodo actual
        if (root.val == val) {
            return root;
        }

        // Si val es menor que el valor del nodo actual, buscamos en el subárbol izquierdo
        if (val < root.val) {
            return solution(root.left, val);
        }

        // Si val es mayor que el valor del nodo actual, buscamos en el subárbol derecho
        return solution(root.right, val);
    }
}