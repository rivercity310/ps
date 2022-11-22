import sys

input = sys.stdin.readline

def dfs(arr: list[list[int]], i: int, j: int) -> bool:
    if i < 0 or j < 0 or i >= len(arr) or j >= len(arr[i]):
        return False

    if arr[i][j] == 0:
        arr[i][j] = 1
        dfs(arr, i, j)

        return True

    if arr[i][j] == 1:

        dfs(arr, i + 1, j)
        dfs(arr, i - 1, j)
        dfs(arr, i, j + 1)
        dfs(arr, i, j - 1)        

        return True

    return False


def solve(arr: list[list[int]]) -> int:
    cnt = 0
    dfs(arr, 0, 0)
    

    return cnt

if __name__ == "__main__":
    m, n = map(int, input().split())
    
    arr = [list(map(int, input().split())) for _ in range(n)]
    print(solve(arr))