package Greedy;

import java.util.Arrays;

public class PRO42885 {
    public static int solution(int[] people, int limit) {
        // 최대한 limit에 가깝게 태워야 한다
        Arrays.sort(people);

        int ans = 0;
        int left = 0;
        int right = people.length - 1;

;       while (left <= right) {
            if (left == right) {
                ans++;
                break;
            }

            if (people[left] + people[right] <= limit) {
                ans++;
                right--;
                left++;
            }

            else {
                ans++;
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] pp = {
                { 70, 50, 80, 50 },
                { 70, 80, 50 }
        };

        int[] limits = { 100, 100 };

        for (int i = 0; i < pp.length; i++) {
            int ans = solution(pp[i], limits[i]);
            System.out.println(ans);
        }
    }
}
