# 퀵정렬

arr = list(map(int, input().split()))

def quick_sort(arr, start, end):
    if start >= end:
        return

    pivot = start
    left = start + 1
    right = end 

    while left <= right:
        while arr[pivot] >= arr[left] and left <= end:
            left += 1

        while arr[pivot] <= arr[right] and right > start:
            right -= 1

        if left > right:
            arr[right], arr[pivot] = arr[pivot], arr[right]
        else:
            arr[left], arr[right] = arr[right], arr[left]

    quick_sort(arr, 0, right - 1)
    quick_sort(arr, right + 1, end)


def pythonic_quick_sort(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[0]
    tail = arr[1:]

    left = [x for x in tail if x <= pivot]
    right = [x for x in tail if x > pivot]

    return pythonic_quick_sort(left) + [pivot] + pythonic_quick_sort(right)

sorted_arr = pythonic_quick_sort(arr)
print(sorted_arr)