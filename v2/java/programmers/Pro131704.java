package programmers;

import java.util.*;

class Pro131704 {
    public int solution(int[] order) {
        Stack<Integer> stk = new Stack<>();

        int ans = 0;
        int idx = 0;

        for (int box = 1; box <= order.length; box++) {
            boolean flag = false;

            if (order[idx] == box) {
                flag = true;
                idx++;
                ans++;
            }

            while (!stk.isEmpty() && stk.peek() == order[idx]) {
                stk.pop();
                idx++;
                ans++;
            }

            if (!flag) stk.add(box);
        }

        return ans;
    }
}
