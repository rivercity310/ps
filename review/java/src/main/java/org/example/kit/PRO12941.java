package org.example.kit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PRO12941 {
    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int j = B.length - 1;
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            ans += (A[i] * B[j--]);
        }

        return ans;
    }
}
