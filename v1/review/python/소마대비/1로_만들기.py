n = int(input())

if n == 1:
    print(0)
elif n == 2 or n == 3:
    print(1)
else:
    dp = [0] * (n + 1)
    dp[2] = 1
    dp[3] = 1

    # dp[n] = min(dp[n / 2], dp[n / 3], dp[n - 1]) + 1
    for i in range(4, n + 1):
        if i % 2 == 0 and i % 3 == 0:
            dp[i] = min(dp[i // 3], dp[i // 2], dp[i - 1]) + 1

        elif i % 3 == 0:
            dp[i] = min(dp[i // 3], dp[i - 1]) + 1

        elif i % 2 == 0:
            dp[i] = min(dp[i // 2], dp[i - 1]) + 1

        else:
            dp[i] = dp[i - 1] + 1

    print(dp[n])
