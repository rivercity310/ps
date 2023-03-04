import java.util.Stack;

public class PRO12981 {
    public static int[] solution(int n, String[] words) {
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            int person = i % n + 1;
            int stage = i / n + 1;
            String word = words[i];

            if (stk.contains(word)) {
                return new int[] { person, stage };
            }

            char firstChar = word.charAt(0);

            if (stk.empty() || stk.peek().charAt(stk.peek().length() - 1) == firstChar)
                stk.push(word);
            else
                return new int[] { person, stage };
        }

        return new int[] { 0, 0 };
    }
}
