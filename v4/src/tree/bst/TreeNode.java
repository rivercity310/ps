package tree.bst;

public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> left;
    TreeNode<E> right;
    private E value;

    public TreeNode(E value) {
        this.value = value;
        this.left = this.right = null;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
