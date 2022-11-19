import sys

input = sys.stdin.readline 

n = int(input())
dist = list(map(int, input().split()))
prices = list(map(int, input().split()))

min_price = int(1e9)
total_price = 0

for i in range(n - 1):
    min_price = min(min_price, prices[i])
    total_price += min_price * dist[i]

print(total_price)