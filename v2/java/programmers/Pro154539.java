package programmers;

import java.util.*;

class Pro154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stk = new Stack<>();
        stk.add(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stk.isEmpty()) {
                if (numbers[stk.peek()] >= numbers[i]) break;
                answer[stk.pop()] = numbers[i];
            }

            stk.add(i);
        }

        return answer;
    }
}
