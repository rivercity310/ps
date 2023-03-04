# Programmers Lv.2
import math
from collections import deque


def solution(progresses, speeds):
    remains = deque()
    for (p, s) in zip(progresses, speeds):
        remain = math.ceil((100 - p) / s)
        remains.append(remain)

    answer = []

    # 5, 10, 1, 1, 20, 1
    # 1, 1, 1, 1, 1, 1

    while remains:
        if len(remains) == 1:
            answer.append(1)
            break

        if remains[0] < remains[1]:
            answer.append(1)
            remains.popleft()

        elif remains[0] >= remains[1]:
            cnt = 1
            for i in range(1, len(remains)):
                if remains[i] <= remains[0]:
                    cnt += 1
                else:
                    break

            for i in range(cnt):
                remains.popleft()

            answer.append(cnt)

    return answer


progresses = [[93, 30, 55], [95, 90, 99, 99, 80, 99]]
speeds = [[1, 30, 5], [1, 1, 1, 1, 1, 1]]

for i in range(2):
    print(solution(progresses[i], speeds[i]))
