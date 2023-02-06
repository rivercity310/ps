# Programmers Lv.2
# https://school.programmers.co.kr/learn/courses/30/lessons/42584

from collections import deque


def solution(prices):
    size = len(prices)
    ans = [i for i in range(size - 1, -1, -1)]

    stk = deque()
    stk.append(0)

    for i in range(1, size):
        while stk and prices[stk[-1]] > prices[i]:
            j = stk.pop()
            ans[j] = i - j

        stk.append(i)

    return ans


prices = [1, 2, 3, 2, 3]
print(solution(prices))
