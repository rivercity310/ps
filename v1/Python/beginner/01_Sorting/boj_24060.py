import sys

input = sys.stdin.readline

cnt = 0
ans = -1

def merging(left: list[int], right: list[int], k: int) -> None:
    global cnt, ans
    result = []

    while len(left) > 0 or len(right) > 0:
        if len(left) > 0 and len(right) > 0:
            if left[0] <= right[0]:
                result.append(left[0])
                left = left[1:]
            else:
                result.append(right[0])
                right = right[1:]
        elif len(left) > 0:
            result.append(left[0])
            left = left[1:]
        elif len(right) > 0:
            result.append(right[0])
            right = right[1:]

        cnt += 1
        if cnt == k:
            ans = result[-1]

    return result

def merge_sort(arr: list[int], k: int) -> None:
    if len(arr) <= 1:
        return arr 
    
    mid = len(arr) // 2
    left_arr = merge_sort(arr[:mid], k)
    right_arr = merge_sort(arr[mid:], k)

    return merging(left_arr, right_arr, k)


if __name__ == "__main__":
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    merge_sort(arr, k)
    print(ans)