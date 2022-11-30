import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
pSum = [0] * (n + 1)
chk = [0] * m

for i in range(1, n + 1):
    pSum[i] = (pSum[i - 1] + arr[i - 1]) % m
    chk[pSum[i]] += 1           # 나머지가 같은 부분합 카운트

rst = chk[0]

for i in range(m):
    rst += (chk[i] * (chk[i] - 1)) // 2

print(rst)
