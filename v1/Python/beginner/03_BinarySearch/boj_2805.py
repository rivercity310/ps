import sys

input = sys.stdin.readline 

def solve(arr: list[int], m: int) -> int:
    left = 0
    right = max(arr)
    ans = 0

    while left <= right:
        mid = (left + right) // 2
        tmp = 0

        for val in arr:
            if val > mid:
                tmp += val - mid

        if tmp < m: 
            right = mid - 1
        else:
            left = mid + 1
            ans = max(ans, mid)

    return ans

if __name__ == '__main__':
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    print(solve(arr, m))