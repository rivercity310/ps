import sys
import heapq

input = sys.stdin.readline 

n = int(input())
pq = []

for _ in range(n):
    start, end = map(int, input().split())
    heapq.heappush(pq, (end, start))

cnt = 0
last = -1

while pq:
    end, start = heapq.heappop(pq)
    
    if start >= last:
        last = end
        cnt += 1

print(cnt)