package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1759 {
    static int L, C;
    static char[] arr;
    static boolean[] chk;
    static StringBuffer sb;

    public static void main(String[] args) {
        sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); C = sc.nextInt();
        arr = new char[C];
        chk = new boolean[C];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        solve(0, 0);
        System.out.print(sb);
    }

    private static void solve(int start, int depth) {
        if (depth == L) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (chk[i]) tmp.append(arr[i]);
            }

            if (valid(tmp.toString())) {
                sb.append(tmp).append('\n');
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (!chk[i]) {
                chk[i] = true;
                solve(i + 1, depth + 1);
                chk[i] = false;
            }
        }
    }

    private static boolean valid(String tmp) {
        // 최소 한개의 모음, 최소 두개의 자음 포함
        int a = 0;
        int b = 0;

        for (char c : tmp.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') a++;
            else b++;
        }

        return a >= 1 && b >= 2;
    }
}

class Boj1759_2 {
    static int L, C;
    static char[] input;
    static char[] pass;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        input = new char[C];
        pass = new char[L];

        for (int i = 0; i < C; i++)
            input[i] = sc.next().charAt(0);

        Arrays.sort(input);
        solve(0, 0, 0);
    }

    private static void solve(int length, int index, int cnt) {
        if (length == L) {
            if (cnt >= 1 && L - cnt >= 2) System.out.println(pass);
            return;
        }

        if (index < C) {
            // 현재 글자를 선택
            pass[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            solve(length + 1, index + 1, cnt + v);

            // 현재 글자 선택 X
            pass[length] = 0;
            solve(length, index + 1, cnt);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}