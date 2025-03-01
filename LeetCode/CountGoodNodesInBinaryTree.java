/*
 * 1448. Count Good Nodes in Binary Tree
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. Recorremos cada nodo una vez.
 *     - Espacio: O(h), dondehh es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=logn.
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

class CountGoodNodesInBinaryTree {
    public int solution(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        // Si el valor del nodo actual es mayor o igual que el máximo actual, es un nodo bueno
        if (node.val >= maxSoFar) {
            count++;
            maxSoFar = node.val; // Actualizar el máximo
        }

        // Recorrer los subárboles izquierdo y derecho
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}