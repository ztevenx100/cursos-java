/*
 * 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * - Trie() Initializes the trie object.
 * - void insert(String word) Inserts the string word into the trie.
 * - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * 
 * - Complejidad:
 *     - Tiempo: O(n), donde n es la longitud de la palabra.
 *     - Espacio: O(1), ya que usamos una cantidad constante de memoria adicional.
*/

class Trie {
    // Clase interna para representar un nodo de la Trie
    private class TrieNode {
        TrieNode[] children; // Arreglo de hijos (uno para cada letra del alfabeto)
        boolean isEnd;       // Indica si este nodo es el final de una palabra

        public TrieNode() {
            children = new TrieNode[26]; // 26 letras del alfabeto inglés
            isEnd = false;
        }
    }

    private TrieNode root; // Nodo raíz de la Trie

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Método para insertar una palabra en la Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Convertir el carácter a un índice (0-25)
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Crear un nuevo nodo si no existe
            }
            current = current.children[index]; // Moverse al nodo hijo
        }
        current.isEnd = true; // Marcar el final de la palabra
    }

    // Método para buscar una palabra en la Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // La palabra no existe
            }
            current = current.children[index];
        }
        return current.isEnd; // Verificar si es el final de una palabra
    }

    // Método para verificar si hay una palabra con el prefijo dado
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // El prefijo no existe
            }
            current = current.children[index];
        }
        return true; // El prefijo existe
    }
}