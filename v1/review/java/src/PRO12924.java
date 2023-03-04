public class PRO12924 {
    public static int solution(int n) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int sum = i;

            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum >= n) break;
            }

            if (sum == n) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
