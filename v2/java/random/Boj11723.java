package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj11723 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int M;
    static Set<Integer> set;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        set = new HashSet<>();
        chk = new boolean[21];

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    if (!chk[j]) {
                        chk[j] = true;
                        set.add(j);
                    }
                }
            }

            else if (op.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    if (chk[j]) {
                        chk[j] = false;
                    }
                }

                set.clear();
            }

            else {
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("add")) {
                    if (!chk[num]) {
                        chk[num] = true;
                        set.add(num);
                    }
                }

                else if (op.equals("remove")) {
                    if (chk[num]) {
                        chk[num] = false;
                        set.remove(num);
                    }
                }

                else if (op.equals("check")) {
                    sb.append(chk[num] ? 1 : 0).append('\n');
                }

                else if (op.equals("toggle")) {
                    if (chk[num]) {
                        chk[num] = false;
                        set.remove(num);
                    } else {
                        chk[num] = true;
                        set.add(num);
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
