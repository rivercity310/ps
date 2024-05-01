package tree.avl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 0; i < 100000; i++) {
            tree.insert(i);
        }

        Scanner scan = new Scanner(System.in);
        while (true) {
            int k = scan.nextInt();
            if (k == -1) break;
            tree.search(k);
        }
    }
}
