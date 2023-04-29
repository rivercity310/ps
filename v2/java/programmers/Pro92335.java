package programmers;

import java.util.*;

class Pro92335 {
    public int solution(int n, int k) {
        String[] strs = getPrimeNumStr(n, k).split("0");
        int answer = 0;

        for (String str : strs) {
            if (str.length() >= 1) {
                if (isPrime(str)) answer++;
            }
        }

        return answer;
    }

    boolean isPrime(String tmp) {
        long k = Long.parseLong(tmp);

        if (k == 1) return false;
        if (k == 2) return true;
        if (k % 2 == 0) return false;

        for (int i = 3; i <= (int) Math.sqrt(k); i += 2) {
            if (k % i == 0) return false;
        }

        return true;
    }

    String getPrimeNumStr(int n, int k) {
        String tmp = "";

        while (n > 0) {
            int a = n % k;
            n /= k;
            tmp += String.valueOf(a);
        }

        return new StringBuilder(tmp).reverse().toString();
    }
}