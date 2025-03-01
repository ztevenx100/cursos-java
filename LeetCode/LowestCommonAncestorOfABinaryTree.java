/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. En el peor caso, recorremos todos los nodos.
 *     - Espacio: O(h), dondehh es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=logn.
*/

class LowestCommonAncestorOfABinaryTree {
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        // Caso base: si el nodo es null, devolvemos null
        if (root == null) {
            return null;
        }

        // Si el nodo actual es p o q, devolvemos el nodo actual
        if (root == p || root == q) {
            return root;
        }

        // Recorrer los subárboles izquierdo y derecho
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);

        // Si ambos subárboles devuelven un nodo no nulo, el nodo actual es el LCA
        if (left != null && right != null) {
            return root;
        }

        // Si solo uno de los subárboles devuelve un nodo no nulo, devolvemos ese nodo
        return left != null ? left : right;
    }
}