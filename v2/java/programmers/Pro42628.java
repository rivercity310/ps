package programmers;

import java.util.StringTokenizer;
import java.util.TreeSet;

public class Pro42628 {
    public static int[] solution(String[] operations) {
        TreeSet<Integer> tr = new TreeSet<>();

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (op.equals("I")) {
                tr.add(num);
            }

            else if (op.equals("D")) {
                if (num == -1) {
                    if (!tr.isEmpty()) {
                        tr.pollFirst();
                    }
                }

                else if (num == 1) {
                    if (!tr.isEmpty()) {
                        tr.pollLast();
                    }
                }
            }
        }

        int[] ans = new int[2];

        if (!tr.isEmpty()) {
            ans[0] = tr.last();
            ans[1] = tr.first();
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] ops = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        String[] ops2 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        int[] solution = solution(ops2);
        System.out.println(solution[0] + " " + solution[1]);
    }
}
