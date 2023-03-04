
class PRO12914 {
    public static long solution(int n) {
        if (n > 2) return solution(n - 1) + solution(n - 2);
        return n;   
    }
}