# 등호만 달라짐

# key 이상의 값이 처음 나타나는 인덱스 반환
def lower_bound(arr: list[int], key: int) -> int:
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2

        if key <= arr[mid]:
            right = mid
        else:
            left = mid + 1
        
    return right

# key를 초과하는 첫 인덱스 반환
def upper_bound(arr: list[int], key: int) -> int:
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2

        if key < arr[mid]:
            right = mid
        else:
            left = mid + 1

    return right

if __name__ == '__main__':
    arr = [1, 3, 5, 5, 5, 7, 9]
    key = 5

    print(f"upper bound 결과 : {upper_bound(arr, key)}")
    print(f"lower bound 결과 : {lower_bound(arr, key)}")