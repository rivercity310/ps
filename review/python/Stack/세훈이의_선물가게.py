import sys
import heapq

input = sys.stdin.readline
A, B, N = map(int, input().split())

q = []
b_end = r_end = 0

for i in range(N):
    tmp = input().split()
    t = int(tmp[0])
    c = tmp[1]
    m = int(tmp[2])

    # 주문 시간 맞추기
    if c == 'R' and r_end > t:
        t = r_end
    elif c == 'B' and b_end > t:
        t = b_end

    j = 0
    while j < m:
        if c == 'B':
            heapq.heappush(q, (t + (A * j), 'B'))
        else:
            heapq.heappush(q, (t + (B * j), 'R'))

        j += 1

    if c == 'B':
        b_end = t + (A * j)
    else:
        r_end = t + (B * j)

a = []
b = []
cnt = 1

while len(q):
    t, c = heapq.heappop(q)
    if c == "B": a.append(cnt)
    else: b.append(cnt)
    cnt += 1

print(len(a))
print(*sorted(a))
print(len(b))
print(*sorted(b))

