package beginner.j_Others

import java.util.*

/* 괄호의 값: 스택을 이용한 문제 */

fun boj_2504() = with(System.`in`.bufferedReader()) {
    val stk = Stack<Char>()
    val str = readLine()

    var tmp = 1
    var ans = 0
    var impossible = false

    for ((i, c) in str.withIndex()) {
        if (c == '(') {
            tmp *= 2
            stk.push(c)
        }
        else if (c == '[') {
            tmp *= 3
            stk.push(c)
        }
        else if (c == ')') {
            if (stk.empty() || stk.peek() != '(') {
                impossible = true
                break
            }

            if (str[i - 1] == '(') ans += tmp

            tmp /= 2
            stk.pop()
        }
        else if (c == ']') {
            if (stk.empty() || stk.peek() != '[') {
                impossible = true
                break
            }

            if (str[i - 1] == '[') ans += tmp

            tmp /= 3
            stk.pop()
        }

        println("tmp : $tmp, ans : $ans")
    }

    if (impossible || stk.isNotEmpty()) print(0)
    else print(ans)
}