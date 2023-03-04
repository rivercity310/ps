import random

def merging(arr: list[int], left: int, mid: int, right: int) -> None:
    tmp = [0] * len(arr)

    i = left
    j = mid + 1
    k = left

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            tmp[k] = arr[i]
            i += 1
        else:
            tmp[k] = arr[j]
            j += 1
        k += 1

    if i > mid:
        for a in range(j, right + 1):
            tmp[k] = arr[a]
            k += 1
    else:
        for a in range(i, mid + 1):
            tmp[k] = arr[a]
            k += 1
    
    for a in range(left, right + 1):
        arr[a] = tmp[a]


def merge_sort(arr: list[int], left: int, right: int) -> None:
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merging(arr, left, mid, right)

if __name__ == '__main__':
    arr = [random.randint(1, 100) for _ in range(10)]

    print("[ 생성된 배열 ]")
    print(*arr)

    merge_sort(arr, 0, len(arr) - 1)

    print("[ 정렬된 배열 ]")
    print(*arr)