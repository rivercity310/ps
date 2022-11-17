import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

max_element = max(arr)
count = [0] * (max_element + 1)

for val in arr:
    count[val] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end=" ")
