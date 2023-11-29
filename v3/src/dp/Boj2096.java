package dp;

import java.io.*;
import java.util.Arrays;


public class Boj2096 {
    static BufferedReader br;
    static int N, M;
    static int[] minArr, maxArr, minTmp, maxTmp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 3;

        minArr = new int[M];
        maxArr = new int[M];
        minTmp = new int[M];
        maxTmp = new int[M];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i == 0) {
                for (int j = 0; j < M; j++) {
                    minTmp[j] = input[j];
                    maxTmp[j] = input[j];
                }
            }

            else {
                for (int j = 0; j < M; j++) {
                    if (j == 0) {
                        minArr[j] = Math.min(minTmp[j], minTmp[j + 1]) + input[j];
                        maxArr[j] = Math.max(maxTmp[j], maxTmp[j + 1]) + input[j];
                    }

                    else if (j == 1) {
                        minArr[j] = Math.min(minTmp[j - 1], Math.min(minTmp[j], minTmp[j + 1])) + input[j];
                        maxArr[j] = Math.max(maxTmp[j - 1], Math.max(maxTmp[j], maxTmp[j + 1])) + input[j];
                    }

                    else {
                        minArr[j] = Math.min(minTmp[j - 1], minTmp[j]) + input[j];
                        maxArr[j] = Math.max(maxTmp[j - 1], maxTmp[j]) + input[j];
                    }
                }

                for (int j = 0; j < M; j++) {
                    minTmp[j] = minArr[j];
                    maxTmp[j] = maxArr[j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            min = Math.min(minTmp[i], min);
            max = Math.max(maxTmp[i], max);
        }

        System.out.println(max + " " + min);
    }
}
