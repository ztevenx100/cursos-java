/*
 * 1161. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. Recorremos cada nodo una vez.
 *     - Espacio: O(n), ya que en el peor caso la cola puede contener todos los nodos del último nivel.
*/

import java.util.LinkedList;
import java.util.Queue;

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

class MaximumLevelSumOfABinaryTree {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Cola para el recorrido BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE; // Inicializar la suma máxima con el valor mínimo posible
        int maxLevel = 0; // Inicializar el nivel con la suma máxima
        int currentLevel = 0; // Contador de niveles

        while (!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            int levelSum = 0;

            // Recorrer todos los nodos en el nivel actual
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // Agregar los hijos del nodo actual a la cola
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Actualizar la suma máxima y el nivel correspondiente
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
        }

        return maxLevel;
    }
}