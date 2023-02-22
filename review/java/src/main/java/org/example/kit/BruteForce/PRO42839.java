package org.example.kit.BruteForce;

import java.util.*;

public class PRO42839 {
    private Set<Integer> set;
    private boolean[] used;
    private char[] char_nums;

    public int solution(String numbers) {
        char_nums = numbers.toCharArray();
        used = new boolean[char_nums.length];
        set = new HashSet<>();

        backTracking("");
        int ans = 0;

        for (Integer a : set) {
            if (isPrime(a)) {
                System.out.println("a = " + a);
                ans++;
            }
        }

        return ans;
    }

    private void backTracking(String s) {
        for (int i = 0; i < char_nums.length; i++) {
            if (!used[i]) {
                s += char_nums[i];
                used[i] = true;

                backTracking(s);

                s = s.substring(0, s.length() - 1);
                used[i] = false;
            }

            else {
                set.add(Integer.parseInt(s));
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] nums = { "17", "011" };

        Arrays.stream(nums).forEach(num -> {
            int ans = new PRO42839().solution(num);
            System.out.println(ans);
        });
    }
}
