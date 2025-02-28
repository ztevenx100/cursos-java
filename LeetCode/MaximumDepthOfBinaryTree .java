/*
 * 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es el número de nodos en el árbol. Visitamos cada nodo una vez.
 *     - Espacio: O(1),  donde h es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=logn.
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


class MaximumDepthOfBinaryTree  {
    public int solution(TreeNode root) {
        // Caso base: si el nodo es null, la profundidad es 0
        if (root == null) {
            return 0;
        }

        // Recursión: calcular la profundidad máxima de los subárboles izquierdo y derecho
        int leftDepth = solution(root.left);
        int rightDepth = solution(root.right);

        // La profundidad máxima es el máximo de las profundidades de los subárboles más 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}