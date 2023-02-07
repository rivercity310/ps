import sys

n = int(sys.stdin.readline())
stair = list()

for i in range(n):
    stair.append(int(sys.stdin.readline()))

if n == 1:
    print(stair[0])
elif n == 2:
    print(stair[0] + stair[1])
else:
    # n == 3: (1, 3), (2, 3)       stair[n] + max(dp[n - 1], dp[n - 2])
    # n == 4: (1, 2, 4), (1, 3, 4)
    # n == 5: (1, 3, 5), (1, 2, 4, 5)

    dp = [0] * (n + 1)
    dp[1] = stair[1]
    dp[2] = dp[1] + stair[2]
    dp[3] = max(dp[1], stair[2]) + stair[3]

    for i in range(4, n + 1):
        pass

    print(dp[n])

