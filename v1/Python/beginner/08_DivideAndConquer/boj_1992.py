import sys

input = sys.stdin.readline

n = int(input())

v = []
for _ in range(n):
    v.append(map(int, list(input().split())))

print(v)