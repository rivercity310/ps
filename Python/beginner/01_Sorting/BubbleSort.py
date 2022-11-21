# 버블정렬
arr = list(map(int, input().split()))

def bubble_sort():
    for i in range(1, len(arr)):
        for j in range(len(arr) - 1, i - 1, -1):
            if arr[j - 1] > arr[j]:
                print(f"{arr[j - 1]} <--> {arr[j]}")
                arr[j - 1], arr[j] = arr[j], arr[j - 1]

bubble_sort()
print(arr)
