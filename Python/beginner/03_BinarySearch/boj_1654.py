import sys

input = sys.stdin.readline 

# n개를 만들 수 있는 랜선의 최대 길이를 구하라
def solve(arr: list[int], n: int) -> int:
    left = 1
    right = max(arr)
    ans = 0

    while left <= right:
        mid = (left + right) // 2
        tmp = 0

        for val in arr:
            tmp += val // mid
        
        if tmp < n:
            right = mid - 1
        else:
            left = mid + 1
            ans = max(ans, mid)     # n개를 만들 수 있을 때 답을 더 큰 값으로 계속 갱신

    return ans

if __name__ == '__main__':
    k, n = map(int, input().split())
    arr = [int(input()) for _ in range(k)]

    print(solve(arr, n))