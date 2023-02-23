package org.example.kit;

public class PRO12939 {
    public String solution(String s) {
        String[] str = s.split("\\s");

        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;

        for (String ss : str) {
            int i = Integer.parseInt(ss);

            if (i > max_num) max_num = i;
            if (i < min_num) min_num = i;
        }

        String ans = min_num + " " + max_num;
        return ans;
    }
}
