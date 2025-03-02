/*
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * - Complejidad:
 *     - Tiempo: O(h), dondehh es la altura del árbol. En el peor caso (árbol completamente desbalanceado), h=n. En el mejor caso (árbol balanceado), h=logn.
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

class DeleteNodeInABST {
    public TreeNode solution(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Buscar el nodo a eliminar
        if (key < root.val) {
            root.left = solution(root.left, key);
        } else if (key > root.val) {
            root.right = solution(root.right, key);
        } else {
            // Caso 1: El nodo es una hoja (no tiene hijos)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Caso 2: El nodo tiene un solo hijo
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Caso 3: El nodo tiene dos hijos
            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val; // Copiar el valor del sucesor
            root.right = solution(root.right, successor.val); // Eliminar el sucesor
        }

        return root;
    }

    // Método para encontrar el sucesor inmediato (el nodo más pequeño en el subárbol derecho)
    private TreeNode findSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}