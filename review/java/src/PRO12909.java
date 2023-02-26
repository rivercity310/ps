import java.util.ArrayDeque;
import java.util.Deque;

public class PRO12909 {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                dq.add(c);

            else if (c == ')') {
                if (dq.isEmpty())
                    return false;

                if (dq.peek() == '(')
                    dq.removeLast();
            }
        }

        return dq.isEmpty();
    }
}
