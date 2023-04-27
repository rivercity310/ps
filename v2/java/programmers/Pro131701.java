package programmers;

import java.util.*;

class Pro131701 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int link = 1; link <= elements.length; link++) {
            for (int i = 0; i < elements.length; i++) {
                int s = getLinkedSum(elements, link, i);
                set.add(s);
            }
        }

        return set.size();
    }

    int getLinkedSum(int[] elements, int link, int start) {
        int sum = 0;

        for (int i = start; i < start + link; i++) {
            sum += elements[i % elements.length];
        }

        return sum;
    }
}
