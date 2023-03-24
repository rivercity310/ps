package part1.string;

import java.util.Scanner;

public class Boj2744 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'A' && c <= 'Z') System.out.print((char)(c - 'A' + 'a'));
            else System.out.print((char)(c - 'a' + 'A'));
        }
    }
}
