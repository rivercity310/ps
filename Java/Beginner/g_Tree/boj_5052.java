package Beginner.g_Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_5052 {
    static int t;
    static int n;

    static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isFinal = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        boolean insert(String number) {
            TrieNode curNode = root;

            for (int i = 0; i < number.length(); i++) {
                char ch = number.charAt(i);

                if (curNode.childNodes.get(ch) == null) {
                    curNode.childNodes.put(ch, new TrieNode());
                }

                curNode = curNode.childNodes.get(ch);

                if (curNode.isFinal) {
                    return false;
                }
            }

            if (curNode.childNodes.size() != 0) {
                return false;
            }

            curNode.isFinal = true;
            return true;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            boolean flag = true;

            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                if (!trie.insert(br.readLine())) {
                    flag = false;
                }
            }

            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
