package random;

import java.util.*;
import java.io.*;

public class Boj1935 {
    static BufferedReader br;
    static StringBuffer sb;
    static int N;
    static double M;
    static Map<Character, Double> m;
    static Stack<Double> stk;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        m = new HashMap<>();
        stk = new Stack<>();

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < N; i++) {
            M = Double.parseDouble(br.readLine());
            m.put((char)('A' + i), M);
        }

        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                double val = m.get(c);
                stk.push(val);
            }

            else {
                double op2 = stk.pop();
                double op1 = stk.pop();

                switch (c) {
                    case '+': stk.push(op1 + op2); break;
                    case '-': stk.push(op1 - op2); break;
                    case '*': stk.push(op1 * op2); break;
                    case '/': stk.push(op1 / op2); break;
                }
            }
        }

        System.out.printf("%.2f", stk.pop());
    }
}