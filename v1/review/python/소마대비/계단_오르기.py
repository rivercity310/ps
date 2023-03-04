import sys

n = int(sys.stdin.readline())
stair = list([0])

for i in range(n):
    stair.append(int(sys.stdin.readline()))

if n == 1:
    print(stair[1])
elif n == 2:
    print(stair[1] + stair[2])
else:
    dp = [0] * (n + 1)
    dp[1] = stair[1]
    dp[2] = dp[1] + stair[2]
    dp[3] = max(dp[1], stair[2]) + stair[3]

    for i in range(4, n + 1):
        dp[i] = max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i]

    print(dp[n])

