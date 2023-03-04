import sys

# 손님이 요청한 길이가 M일 때, 적어도 M만큼의 떡을 얻기 위해서
# 절단기에 설정할 수 있는 높이의 최댓값

input = sys.stdin.readline

def cutter(arr, m):
    left = 0
    right = max(arr)
    result = 0

    while left <= right:
        mid = (left + right) // 2
        tmp = 0

        for t in arr:
            if t > mid:
                tmp += t - mid
        
        if tmp < m:
            right = mid - 1
        else:
            left = mid + 1
            result = mid

    return result

if __name__ == '__main__':
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    result = cutter(arr, m)
    print(result)