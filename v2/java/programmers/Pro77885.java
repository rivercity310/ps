package programmers;

import java.util.*;

class Pro77885 {
    // numbers = [2, 7]
    // ans = [3, 8]
    // 10, 11 -> 01 00
    // 0111, 1000 -> 1111 -> 0011
    // 11
    public long[] sol(long[] numbers) {
        long[] ans = numbers.clone();

        for (int i = 0; i < numbers.length; i++) {
            ans[i]++;
            ans[i] += (ans[i]^numbers[i]) >>> 2;
        }

        return ans;
    }

    public long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        int idx = 0;

        for (long number : numbers) {
            if (number % 2 == 0) ans[idx] = number + 1;
            else {
                // 1. 첫번째 등장하는 0 -> 1, 나머지 0
                // 2. 원래수 + 구한 수 - (구한수 / 2)
                // ===> 원래수 + (구한 수 / 2)

                // ex) 5(101)
                // 101 + 10 - 01 = 101 + 01 = 110(6)

                // ex) 7(111)
                // 111 + 100 = 1011 (11)

                String nl = Long.toString(number, 2);
                int zdx = -1;
                StringBuilder tmp = new StringBuilder("1");

                for (int i = 0; i < nl.length(); i++) {
                    if (nl.charAt(i) == '0') zdx = i;
                }

                // 0이 등장하는가 ?
                if (zdx == -1) {
                    tmp.append("0".repeat(nl.length()));
                } else {
                    tmp.append("0".repeat(Math.max(0, nl.length() - (zdx + 1))));
                }

                long tl = Long.parseLong(tmp.toString(), 2);
                ans[idx] = number + (tl / 2);
            }

            idx++;
        }

        return ans;
    }
}
