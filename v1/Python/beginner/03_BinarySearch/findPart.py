import sys

input = sys.stdin.readline

# 손님이 요청한 m개의 부품이 있으면 yes를, 없으면 no를 출력하자!

# 이진탐색을 이용한 풀이
def bin_search(arr, start, end, target):
    if start > end:
        return None

    mid = (start + end) // 2
    
    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return bin_search(arr, start, mid - 1, target)
    else:
        return bin_search(arr, mid + 1, end, target)

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()

    m = int(input())
    find = list(map(int, input().split()))

    for f in find:
        result = bin_search(arr, 0, n - 1, f)
        print("no") if result == None else print("yes")
        
# 그 외에도 계수정렬 개념을 이용한 풀이나, 
# 집합 자료형을 이용한 풀이가 가능하다 
# if f in set -> yes, no
