package Beginner.B_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1931 {
    private static int[][] table;
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        table = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table, (o1, o2) -> {
            if (o1[1] == o2[1])         // 종료 시간이 같을 경우 시작이 빠른 순
                return o1[0] - o2[0];

            return o1[1] - o2[1];
        });

        int cnt = 0;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (table[i][0] >= last) {
                last = table[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

/* 우선순위 큐를 활용한 풀이 */
class Boj_1931_2 {
    // Comparator(compareTo) 또는 Comparable(compare) Interface : 객체를 비교할 수 있도록 만들어준다.
    // https://st-lab.tistory.com/243
    private static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        // 우선순위 큐에 객체를 삽입하기 위한 비교함수
        @Override
        public int compareTo(Pair o) {
            return this.x - o.getX();
        }
    }

    private static StringTokenizer st;
    private static PriorityQueue<Pair> pq;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // pq = new PriorityQueue<>(Collections.reverseOrder());      // 최대힙
        pq = new PriorityQueue<>();                                   // default : 최소힙

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Pair(end, start));
        }

        int cnt = 0;
        int last = -1;

        while (!pq.isEmpty()) {
            // int[] tmp = Arrays.stream(pq.poll()).mapToInt(i -> i).toArray();     // Integer[] -> int[]
            Pair tmp = pq.poll();
            int start = tmp.getY();
            int end = tmp.getX();

            if (start >= last) {
                last = end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
