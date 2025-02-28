import java.util.ArrayList;
import java.util.List;

/*
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * 
 * - Complejidad:
 *     - Tiempo: O(n+m), donde n y m son el número de nodos en root1 y root2, respectivamente. Recorremos ambos árboles una vez.
 *     - Espacio: O(n+m), ya que almacenamos las secuencias de hojas de ambos árboles.
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

class LeafSimilarTrees {
    public boolean solution(TreeNode root1, TreeNode root2){
        // Obtener la secuencia de hojas de ambos árboles
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        // Comparar las secuencias de hojas
        return leaves1.equals(leaves2);
    }

    private static void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val); // Es una hoja, agregar a la lista
        }
        getLeaves(root.left, leaves);  // Recorrer el subárbol izquierdo
        getLeaves(root.right, leaves); // Recorrer el subárbol derecho
    }
}




























