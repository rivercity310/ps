package part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        /* 정석 풀이
        int cnt = 0;
        int start = 0;

        while (true) {
            int idx = doc.indexOf(word, start);
            if (idx == -1) break;
            cnt++;
            start = idx + word.length();
        }
        */

        int cnt = (doc.length() - doc.replace(word, "").length()) / word.length();
        System.out.println(cnt);
        br.close();
    }
}
