/*
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), dondenn es el número de nodos en el árbol. Recorremos cada nodo una vez.
 *     - Espacio: O(n), ya que en el peor caso la cola puede contener todos los nodos del último nivel.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Cola para el recorrido BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Recorrer todos los nodos en el nivel actual
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Si es el último nodo en el nivel, agregarlo a la lista de resultados
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Agregar los hijos del nodo actual a la cola
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }
}