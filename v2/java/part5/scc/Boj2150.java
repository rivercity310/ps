package part5.scc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2150 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static List<Integer>[] grp, reverse, res;
    static boolean[] visited;
    static Stack<Integer> stk;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V + 1];
        grp = new ArrayList[V + 1];
        reverse = new ArrayList[V + 1];
        res = new ArrayList[V + 1];
        stk = new Stack<>();

        for (int i = 0; i <= V; i++) {
            grp[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
            res[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grp[a].add(b);
            reverse[b].add(a);
        }

        for (int i = 1; i <= V; i++)
            if (!visited[i])
                dfs(i);

        Arrays.fill(visited, false);
        int group = 0;

        while (!stk.empty()) {
            int start = stk.pop();
            if (visited[start]) continue;
            redfs(start, group);
            group++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(group).append('\n');
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < group; i++) {
            Collections.sort(res[i]);
            map.put(res[i].get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (int now : res[value])
                sb.append(now).append(' ');
            sb.append("-1").append('\n');
        });

        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int now : grp[start])
            if (!visited[now])
                dfs(now);

        stk.push(start);
    }

    static void redfs(int start, int group) {
        visited[start] = true;
        res[group].add(start);

        for (int now : reverse[start])
            if (!visited[now])
                redfs(now, group);
    }
}
