import sys
from typing import Tuple, List, Any


def makeArr(arr, n) -> tuple[list[Any], list[Any], list[Any], list[Any]]:
    lt = list()

    for i in range(n):
        lt.append(arr[n])








def chk(arr, r, c) -> bool:
    pass


def solve(arr, n) -> type(None):
    if n == 1:
        print(arr[n][n])
        return

    lt, rt, lb, rb = makeArr(arr)

    print("(")
    if not chk(lt):
        solve()

    print(")")


n = int(sys.stdin.readline())
arr = [list(sys.stdin.readline().split()) for _ in range(n)]
