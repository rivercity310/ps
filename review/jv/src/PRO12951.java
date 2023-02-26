import java.util.Arrays;

public class PRO12951 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : sp) {
            sb.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "3people unFollowed me", "for the last week" };

        Arrays.stream(strs)
                .forEach(str -> System.out.println(solution(str)));
    }


}
