import sys

input = sys.stdin.readline 

def install(arr: list[int], n: int, mid: int) -> int:
    # 첫번째 집은 무조건 설치해야 한다.
    router = 1
    last = arr[0]

    for i in range(1, n):
        loc = arr[i]

        # mid 거리 이상이면 라우터를 설치한다.
        # last는 마지막으로 설치한 집의 위치를 저장하는 변수
        if (loc >= last + mid):
            router += 1
            last = loc

    return router
    


# "최대 거리"를 구해야 하므로 Upper Bound 방식으로 풀어야 한다.
def solve(arr: list[int], n: int, c: int) -> int:
    left = 1
    right = arr[n - 1] - arr[0] + 1

    while left < right:
        mid = (left + right) // 2
        router = install(arr, n, mid)

        if router < c:
            right = mid 
        else:
            left = mid + 1
    
    return right - 1


if __name__ == '__main__':
    n, c = map(int, input().split())
    arr = [int(input()) for _ in range(n)]
    arr.sort()

    print(solve(arr, n, c))