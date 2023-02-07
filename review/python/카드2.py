from collections import deque

N = int(input())
dq = deque()

for i in range(N):
    dq.append(i + 1)

while True:
    if len(dq) == 1:
        print(dq.popleft())
        break
    dq.popleft()
    dq.append(dq.popleft())
