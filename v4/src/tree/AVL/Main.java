package tree.AVL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();
        Scanner scan = new Scanner(System.in);

        while (true) {
            int k = scan.nextInt();
            if (k == -1) break;
            tree.insert(k);
            tree.preorder();
        }

        while (true) {
            int k = scan.nextInt();
            if (k == -1) break;
            tree.delete(k);
            tree.preorder();
        }
    }
}
