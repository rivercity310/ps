from collections import deque

N, K = map(int, input().split())
dq = deque()
result = []

for i in range(N):
    dq.append(i + 1)

while len(dq) != 0:
    for i in range(K):
        if i == K - 1:
            result.append(dq.popleft())
        else:
            dq.append(dq.popleft())

print("<", end="")
print(*result, sep=", ", end="")
print(">")
