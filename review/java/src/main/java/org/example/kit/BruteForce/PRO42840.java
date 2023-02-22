package org.example.kit.BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO42840 {

    public static int[] solution(int[] answer) {
        int[] st1 = { 1, 2, 3, 4, 5 };
        int[] st2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] st3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        List<int[]> sts = new ArrayList<>();
        sts.add(st1);
        sts.add(st2);
        sts.add(st3);

        int[] cnts = { 0, 0, 0 };

        for (int i = 0; i < answer.length; i++) {
            int ans = answer[i];

            for (int j = 0; j < sts.size(); j++) {
                int[] st = sts.get(j);
                if (ans == st[i % st.length]) cnts[j]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int max_cnt = Arrays.stream(cnts).max().getAsInt();

        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] == max_cnt) {
                ans.add(i + 1);
            }
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        List<int[]> answers = new ArrayList<>();

        answers.add(new int[] { 1, 2, 3, 4, 5 });
        answers.add(new int[] { 1, 3, 2, 4, 2 });

        answers.forEach(answer ->
                System.out.println(Arrays.toString(solution(answer))));
    }
}
