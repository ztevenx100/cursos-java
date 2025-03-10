/*
 * 1372. Longest ZigZag Path in a Binary Tree
 * You are given the root of a binary tree.
 * A ZigZag path for a binary tree is defined as follow:
 * - Choose any node in the binary tree and a direction (right or left).
 * - If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * - Change the direction from right to left or from left to right.
 * - Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * Return the longest ZigZag path contained in that tree.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. Recorremos cada nodo una vez.
 *     - Espacio: O(h), donde h es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=log⁡n.
*/

/*class TreeNode {
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
}*/

class LongestZigZagPathInABinaryTree {
    private static int maxLength = 0; // Variable para almacenar la longitud máxima del camino ZigZag

    public static int solution(TreeNode root) {
        if (root == null)return 0;
        maxLength = 0;

        // Iniciar el recorrido desde la raíz
        dfs(root, 0, true);  // Ir a la izquierda primero
        dfs(root, 0, false); // Ir a la derecha primero
        return maxLength;
    }

    private static void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        
        System.out.println("node: " + node);
        System.out.println("node-left: " + node.left);
        System.out.println("node-right: " + node.right);
        System.out.println("maxLength: " + maxLength);
        
        // Actualizar la longitud máxima
        maxLength = Math.max(maxLength, length);

        if (isLeft) {
            // Si la dirección anterior fue izquierda, ahora vamos a la derecha
            if (node.right != null) {
                dfs(node.right, length + 1, false);
            }
            // Reiniciar el camino si vamos a la izquierda de nuevo
            if (node.left != null) {
                dfs(node.left, 1, true);
            }
        } else {
            // Si la dirección anterior fue derecha, ahora vamos a la izquierda
            if (node.left != null) {
                dfs(node.left, length + 1, true);
            }
            // Reiniciar el camino si vamos a la derecha de nuevo
            if (node.right != null) {
                dfs(node.right, 1, false);
            }
        }
    }

    public static void main(String[] args) {
        // Crear el árbol binario del caso de prueba
        TreeNode root = new TreeNode(1);

        // Calcular la longitud del camino ZigZag más largo
        System.out.println(solution(root)); // Output: 0
    }
}