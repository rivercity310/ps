package tree.BST;


import java.util.Optional;

public class BinarySearchTree<E extends KeyComparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    public void insert(E value) {
        int oldSize = size;
        root = _insert(root, value);
        if (size > oldSize) {
            System.out.println("Successfully inserted value into Binary Search Tree " + value);
        }
    }

    private TreeNode<E> _insert(TreeNode<E> node, E value) {
        if (node == null) {
            size++;
            return new TreeNode<>(value);
        }

        E nodeValue = node.getValue();
        if (nodeValue.compareTo(value) < 0) node.right = _insert(node.right, value);
        else if (nodeValue.compareTo(value) > 0) node.left = _insert(node.left, value);
        return node;
    }

    public void remove(E value) {
        root = _remove(root, value);
    }

    private TreeNode<E> _remove(TreeNode<E> node, E value) {
        if (node == null) {
            return null;
        }

        E nodeValue = node.getValue();
        if (nodeValue.compareTo(value) > 0) node.left = _remove(node.left, value);
        else if (nodeValue.compareTo(value) < 0) node.right = _remove(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // 왼쪽 서브트리에서 가장 큰 값 찾기 (후계자 노드)
            E successorValue = findSuccessorValue(node.left);
            node.setValue(successorValue);
            node.left = _remove(node.left, successorValue);
        }

        return node;
    }

    public Optional<E> search(int key) {
        TreeNode<E> node = _search(root, key);
        return Optional.ofNullable(node != null ? node.getValue() : null);
    }

    private TreeNode<E> _search(TreeNode<E> node, int key) {
        if (node == null) return null;

        int currentKey = node.getValue().key;
        if (currentKey < key) return _search(node.right, key);
        else if (currentKey > key) return _search(node.left, key);
        return node;
    }

    public int size() {
        return this.size;
    }

    private E findSuccessorValue(TreeNode<E> node) {
        E value = node.getValue();

        while (node != null) {
            node = node.right;
            value = node.getValue();
        }

        return value;
    }

    public void preOrder() {
        _preOrder(root);
        System.out.println();
    }

    private void _preOrder(TreeNode<E> node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        _preOrder(node.left);
        _preOrder(node.right);
    }

    public void inOrder() {
        _inOrder(root);
        System.out.println();
    }

    private void _inOrder(TreeNode<E> node) {
        if (node == null) return;
        _inOrder(node.left);
        System.out.print(node.getValue() + " ");
        _inOrder(node.right);
    }

    public void postOrder() {
        _postOrder(root);
        System.out.println();
    }

    private void _postOrder(TreeNode<E> node) {
        if (node == null) return;
        _postOrder(node.left);
        _postOrder(node.right);
        System.out.print(node.getValue() + " ");
    }
}
