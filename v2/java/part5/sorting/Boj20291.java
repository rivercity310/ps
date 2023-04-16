package part5.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Boj20291 {
    static BufferedReader br;
    static StringBuffer sb;
    static Map<String, Integer> m;
    static String[] files;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        m = new TreeMap<>();

        N = Integer.parseInt(br.readLine());
        files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        Arrays.sort(files);

        for (String file : files) {
            String ext = file.substring(file.indexOf(".") + 1);
            m.merge(ext, 1, Integer::sum);
        }

        for (String key : m.keySet()) {
            sb.append(key).append(" ").append(m.get(key));
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
