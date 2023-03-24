package part1.string;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1157 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next().toUpperCase();
        int[] cnt = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            cnt[c - 'A']++;
        }

        int max = Arrays.stream(cnt).max().getAsInt();
        int counter = 0;
        int idx = -1;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                counter++;
                idx = i;
            }
        }

        if (counter > 1) System.out.println('?');
        else System.out.println((char)('A' + idx));
    }
}
