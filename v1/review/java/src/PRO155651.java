package org.example.kit;


import java.util.*;

public class PRO155651 {
    private static int CLEAN_TIME = 10;
    private static int T = 24 * 60 + 10;


    public static int solution(String[][] book_time) {
        int[] times = new int[T];
        int ans = 0;

        for (String[] book : book_time) {
            String in = book[0];
            String out = book[1];

            int in_hour = Integer.parseInt(in.substring(0, 2));
            int in_minute = Integer.parseInt(in.substring(3));
            int out_hour = Integer.parseInt(out.substring(0, 2));
            int out_minute = Integer.parseInt(out.substring(3));

            int in_time = in_hour * 60 + in_minute;
            int out_time = out_hour * 60 + out_minute;

            times[in_time]++;
            times[out_time]--;
        }

        for (int i = 1; i < T; i++) {
            times[i] += times[i - 1];
            ans = Math.max(ans, times[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[][][] book_times = {
                {
                        {"15:00", "17:00"},
                        {"16:40", "18:20"},
                        {"14:20", "15:20"},
                        {"14:10", "19:20"},
                        {"18:20", "21:20"}
                },
                {
                        {"09:10", "10:10"},
                        {"10:20", "12:20"}
                },
                {
                        {"10:20", "12:30"},
                        {"10:20", "12:30"},
                        {"10:20", "12:30"}
                }
        };

        for (int i = 0; i < book_times.length; i++) {
            System.out.println(solution(book_times[i]));
        }
    }
}
