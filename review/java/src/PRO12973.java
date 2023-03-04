import java.util.ArrayDeque;
import java.util.Deque;

public class PRO12973 {
    private static final Deque<Character> stk = new ArrayDeque<>();

    public static int solution(String s) {
        for (char c : s.toCharArray()) {
            if (stk.isEmpty() || stk.peekLast() != c) stk.addLast(c);
            else stk.removeLast();
        }

        return stk.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
}
