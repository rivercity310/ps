# 재귀로 구현한 이진탐색 코드
def bin_search_recursive(arr, start, end, target):
    if start > end:
        return None

    mid = (start + end) // 2

    if arr[mid] == target: 
        return mid
    elif arr[mid] > target:
        return bin_search_recursive(arr, start, mid - 1, target)
    else:
        return bin_search_recursive(arr, mid + 1, end, target)


# 반복문으로 구현한 이진탐색 코드
def bin_search(arr, start, end, target):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target: return mid
        elif arr[mid] > target: end = mid - 1
        else: start = mid + 1

    return None

# 다른 파일에서 import한 경우(모듈) 실행되지 않음
# 현재 스크립트 파일이 메인 프로그램으로 시작되는 경우와, 
# 모듈로 사용할 떄를 구분하는 용도로 사용됨
if __name__ == '__main__':
    n, target = map(int, input().split())
    arr = list(map(int, input().split()))

    arr.sort()

    # result = bin_search_recursive(arr, 0, n - 1, target)
    result = bin_search(arr, 0, n - 1, target)
    if result == None:
        print("원소가 존재하지 않습니다.")
    else:
        print(f"Target {target} : Index {result}에 존재합니다.")