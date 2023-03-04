public class PRO12911 {
    public static int solution(int n) {
        int a = Integer.bitCount(n);
        int b = n + 1;

        while (true) {
            int tmp = Integer.bitCount(b);
            if (a == tmp) break;
            b++;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
