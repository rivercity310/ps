public class PRO12945 {
    private static final int div = 1234567;

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 2] % div) + (dp[i - 1] % div)) % div;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
}
