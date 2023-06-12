package random;

import java.util.*;
import java.io.*;

/* [ 중위 표기식 -> 후위 표기식 변환 알고리즘 ]
 * 1. 피연산자 -> 바로 출력
 * 2. 여는 괄호 -> Stack push
 * 3. 닫는 괄호 -> '('을 만날 때까지 Stack pop
 * 4. 연산자 ('+', '-', '*', '/') -> 연산자 우선순위에 따라 결정
 *
 */
public class Boj1918 {
    static BufferedReader br;
    static StringBuffer sb;
    static Stack<Character> stk;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        stk = new Stack<>();

        String input = br.readLine();

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stk.isEmpty() && prec(c) <= prec(stk.peek())) {
                    sb.append(stk.pop());
                }

                stk.push(c);
            }

            else if (c == '(') {
                stk.push(c);
            }

            else if (c == ')') {
                char op = stk.pop();
                while (op != '(') {
                    sb.append(op);
                    op = stk.pop();
                }
            }
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        System.out.println(sb);
    }

    /* 연산자 우선순위를 결정해주는 메서드 */
    private static int prec(char c) {
        switch (c) {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }

        return -1;
    }
}