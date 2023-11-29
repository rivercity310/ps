import java.io.*;


public class Main {
    static class Node {
        Node left, right;
        int num;

        Node(int num) {
            this.num = num;
            this.left = this.right = null;
        }

        void insert(int k) {
            if (this.num > k) {
                if (this.left == null) this.left = new Node(k);
                else this.left.insert(k);
            }

            else {
                if (this.right == null) this.right = new Node(k);
                else this.right.insert(k);
            }
        }

        static void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.num);
        }
    }

    static BufferedReader br;
    static Node root;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = br.readLine()).isBlank()) {
            int k = Integer.parseInt(input);
            if (root == null) root = new Node(k);
            else root.insert(k);
        }

        Node.postOrder(root);
    }
}