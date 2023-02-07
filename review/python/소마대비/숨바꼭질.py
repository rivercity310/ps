from collections import deque

n, k = map(int, input().split())

limit = 100000
q = deque()
distance = [0] * (limit + 1)
q.append(n)

while q:
    now = q.popleft()

    if now == k:
        print(distance[k])
        break

    for next in (now - 1, now + 1, now * 2):
        if next < 0 or next > limit:
            continue

        if not distance[next]:
            distance[next] = distance[now] + 1
            q.append(next)
