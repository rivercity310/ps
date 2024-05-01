package tree.bst;

import java.util.Optional;
import java.util.UUID;

public class Main {
    static int number;

    static class Runner extends Thread {
        @Override
        public void run() {
            BinarySearchTree<User> bst = new BinarySearchTree<>();

            for (int i = 0; i < 3333; i++) {
                System.out.print(Thread.currentThread().getName() + " ");
                bst.insert(makeRandomUser());
            }

            Optional<User> user = bst.search(33333);
            user.ifPresent(System.out::println);
        }
    }

    static int key;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Runner();
        Thread thread2 = new Runner();
        thread.start();
        thread2.start();

        thread.interrupt();
        thread.join();
        thread2.join();
        System.out.println(number);
    }

    private static User makeRandomUser() {
        String randomName = UUID.randomUUID().toString();
        String randomEmail = UUID.randomUUID().toString();
        int randomWeight = (int)Math.floor(Math.random() * 100);
        return new User(++key, randomWeight, randomName, randomEmail);
    }
}
