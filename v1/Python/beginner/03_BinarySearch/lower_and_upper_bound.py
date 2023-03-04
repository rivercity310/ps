# 이분 탐색: '원하는 값을 찾는 과정', -> 중복값이 있을 때의 문제점

# lower bound는 (원하는 값이 처음 나오는 위치)를,
# upper bound는 (원하는 값이 나오는 마지막 위치 + 1)를 찾는다.
# 즉 경계값을 찾아가는 과정이다.

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

    print(f"left: {left}, right: {right}, mid: {mid}")
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

    print(f"left: {left}, right: {right}, mid: {mid}")
    return right

if __name__ == '__main__':
    arr = [1, 3, 5, 5, 5, 7, 9, 9, 11, 13, 15, 17, 19]
    key = 9

    print(f"lower bound 결과 : {lower_bound(arr, key)}")
    print(f"upper bound 결과 : {upper_bound(arr, key)}")
