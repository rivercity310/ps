import sys
import bisect   # 이진탐색 라이브러리

input = sys.stdin.readline 

n = int(input())
w = list(map(int, input().split()))

arr = list(set(w))      # 리스트 중복 제거 테크닉
arr.sort()

for val in w:
    print(bisect.bisect_left(arr, val), end=" ")




