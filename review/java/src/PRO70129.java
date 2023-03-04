package org.example.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO70129 {
    public static int[] solution(String s) {
        int z = 0;
        int i = 0;

        while (!s.equals("1")) {
            int cnt = 0;

            for (String t : s.split("")) {
                if (t.equals("0")) {
                    cnt++;
                }
            }

            s = s.replaceAll("[0]", "");
            s = Integer.toBinaryString(s.length());

            z += cnt;
            i++;
        }

        return new int[] { i, z };
    }

    public static void main(String[] args) {
        String[] strs = {
                "110010101001",
                "01110",
                "1111111"
        };

        Arrays.stream(strs).forEach(it -> {
            System.out.println(Arrays.toString(solution(it)));
        });
    }
}
