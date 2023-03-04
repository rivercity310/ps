import sys 
from collections import deque

input = sys.stdin.readline
'''

cnt = 0

def dfs(arr: list[list[int]], i: int, j: int) -> bool:
    global cnt
    
    if i < 0 or j < 0 or i >= len(arr) or j >= len(arr[i]):
        cnt -= 1
        return False 

    if arr[i][j] == 2:
        return True

    delta = [(-2, 1), (-2, -1), (-1, 2), (-1, -2), (1, -2), (1, 2), (2, -1), (2, 1)]
    for dx, dy in delta:
        dfs(arr, i + dx, j + dy)




def solve(arr: list[list[int]], sx: int, sy: int) -> int:
    

if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        l = int(input())
        arr = [[0] * l for _ in range(l)]
        
        kx, ky = list(map(int, input().split()))
        tx, ty = list(map(int, input().split()))

        arr[kx][ky] = 1
        arr[tx][ty] = 2

'''
        