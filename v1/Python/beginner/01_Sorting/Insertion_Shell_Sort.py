import random

# [ 삽입정렬 ]
# 아직 정렬되지 않은 부분의 첫번째 요소를 정렬된 부분의 알맞은 위치에 삽입
# tmp보다 작은 값을 찾을 때까지 a[j]에 a[j - 1]을 대입 -> 찾은 위치에 tmp 대입을 반복한다
def insertion_sort(a: list[int]) -> None:
    for i in range(1, len(a)):
        tmp = a[i]

        for j in range(i, -1, -1):
            if a[j - 1] <= tmp:
                break

            a[j] = a[j - 1]
        a[j] = tmp


# [ 셸정렬 O(n^1.25) ] 
# 삽입정렬: 정렬을 마친 상태에 가까워질수록 정렬 속도가 매우 빨라짐 ==> 4정렬 -> 2정렬 -> 1정렬 점점 정렬 상태에 가까워짐
# 삽입정렬의 요소이동 횟수를 줄이기 위해 배열의 요소를 그룹으로 나눠 그룹별 정렬을 수행
# 최적: h의 값이 서로 배수가 되지 않도록 h 증분을 (h * 3 + 1)로 설정, 초깃값은 n / 9
def shell_sort(a: list[int]) -> None:
    n = len(arr)
    h = 1

    while h < n // 9:
        h = h * 3 + 1

    while h > 0:
        for i in range(h, n):
            j = i - h
            tmp = a[i]

            while j >= 0 and a[j] > tmp:
                a[j + h] = a[j]
                j -= h
            a[j + h] = tmp

        h //= 3

if __name__ == '__main__':
    arr = [random.randint(1, 100) for _ in range(30)]
    print("[ 생성된 배열 ]")
    print(*arr)

    insertion_sort(arr)

    print("[ 정렬된 배열 ]")
    print(*arr)