package boj.Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_1655 {
    static final StringBuilder sb = new StringBuilder();
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    static PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

    private static int get_median() {
        // 전체 데이터가 짝수개
        if (min_heap.size() == max_heap.size())
            return Math.min(min_heap.peek(), max_heap.peek());

        // 전체 데이터가 홀수개 -> size가 큰 힙의 루트 리턴
        if (min_heap.size() < max_heap.size())
            return max_heap.peek();

        return min_heap.peek();
    }

    private static void insert(int x) {
        int min_size = min_heap.size();
        int max_size = max_heap.size();

        if (max_size == 0) {
            max_heap.add(x);
            return;
        }

        // 데이터 개수가 짝수인 경우
        if (max_size == min_size) {
            if (x <= get_median()) max_heap.add(x);
            else min_heap.add(x);
        }

        // 이 아래로는 데이터 개수가 홀수인 경우
        else if (max_size < min_size) {
            if (x <= get_median()) max_heap.add(x);
            else {
                max_heap.add(min_heap.poll());
                min_heap.add(x);
            }
        }

        else {
            if (x < get_median()) {
                min_heap.add(max_heap.poll());
                max_heap.add(x);
            }
            else min_heap.add(x);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            insert(x);
            sb.append(get_median()).append("\n");
        }

        System.out.print(sb);
    }
}
