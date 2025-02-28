/*
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), ya que recorremos el arreglo una sola vez.
 *     - Espacio: O(1), ya que solo usamos variables adicionales constantes.
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