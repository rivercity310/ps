package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639 {
    static class Node {
        private final int num;
        private Node left;
        private Node right;

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < num) {
                if (this.left == null) this.left = new Node(n, null, null);
                else this.left.insert(n);
            }

            else {
                if (this.right == null) this.right = new Node(n, null, null);
                else this.right.insert(n);
            }
        }
    }

    static BufferedReader br;
    static Node root;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()), null, null);
        String tmp;
        while (true) {
            tmp = br.readLine();
            if (tmp == null || tmp.isEmpty()) break;
            root.insert(Integer.parseInt(tmp));
        }

        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
