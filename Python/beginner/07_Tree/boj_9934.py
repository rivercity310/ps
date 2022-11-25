import math
import sys

# 중위순회 결과가 주어질 때 트리 원형을 찾는 문제... -> 이분탐색

ans = [[] for _ in range(11)]


def solve(arr: list[int], left: int, right: int, depth: int) -> None:
    if depth > int(math.log2(len(arr) + 1)):
        return

    mid = (left + right) // 2
    ans[depth].append(arr[mid])

    solve(arr, left, mid - 1, depth + 1)
    solve(arr, mid + 1, right, depth + 1)


if __name__ == "__main__":
    input = sys.stdin.readline

    k = int(input())   # 가득 찼을 경우 전체 노드 개수 : (2^depth - 1) 개
    arr = list(map(int, input().split()))   # inorder 결과를 담은 배열

    solve(arr, 0, len(arr) - 1, 1)

    for a in ans[1:k + 1]:
        print(*a)
