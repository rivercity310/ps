# 거스름돈 문제
n = int(input())

# 각 동전은 무한대로 존재한다고 가정했을 때, 최소 동전 개수
coins = [500, 100, 50, 10]
coins_cnt = [0, 0, 0, 0]

for i, coin in enumerate(coins):
    coins_cnt[i] += n // coin
    n %= coin 

print("[ 동전의 개수 ]")
print(*coins_cnt)