n, k = map(int, input().split())

if n == k:
    print(0)

elif abs(n - k) == 1:
    print(1)

else:
    # k가 항상 n보다 크도록
    if n > k:
        n, k = k, n

    inf = int(1e9)
    dp = [inf] * (k * 2 + 1)
    dp[n] = 0

    for i in range(n - 1, n - 10, -1):
        dp[n] = dp[n + 1] + 1

    for i in range(n, k * 2):
        while i * 2 < k * 2:
            print(f'dp[{i * 2}] -> {dp[i] + 1}')
            dp[i * 2] = dp[i] + 1

    for i in range(n + 1, k * 2):
        if i % 2 == 0:
            dp[i] = min(dp[i // 2], dp[i - 1], dp[i + 1]) + 1
        else:
            dp[i] = min(dp[i - 1], dp[i + 1]) + 1

    print(dp[k])
    print(dp)
