package programmers;

import java.util.*;

class Pro49993 {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;

        for (String tr : skill_trees) {
            Stack<Integer> stk = new Stack<>();
            boolean flag = true;

            for (char c : skill.toCharArray()) {
                int idx = findChar(tr, c);

                // 스택이 비었으면 푸쉬한다.
                if (stk.isEmpty()) {
                    stk.add(idx);
                }

                else {
                    // 스택 peek 값과 비교한다.
                    // 선행스킬을 찍기 전 이후 스킬을 배운 경우에 해당
                    if (stk.peek() > idx) {
                        flag = false;
                        break;
                    }
                    else stk.add(idx);
                }
            }

            if (flag) ans++;
        }

        return ans;
    }

    int findChar(String tr, char key) {
        for (int i = 0; i < tr.length(); i++) {
            if (tr.charAt(i) == key) {
                return i;
            }
        }

        return 22;
    }
}