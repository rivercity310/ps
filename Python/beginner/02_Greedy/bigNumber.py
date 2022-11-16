import sys

input = sys.stdin.readline 

# 큰수의 법칙
# 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
# 단 특정 인덱스에 해당하는 수는 연속해서 K번까지 덧셈 가능

N, M, K = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort(reverse=True)

# 단순 풀이
def solution1():
    global M

    rst = 0
    cnt = 0

    while (M):
        if cnt == 3:
            rst += arr[1]
            cnt = 0
        else:
            rst += arr[0]
            cnt += 1

        M -= 1

    print(rst)


# 수열을 이용한 풀이
# {(K * arr[0]) + arr[1]}의 길이가 (K + 1)이 반복되는 형태 
# 나머지는 arr[0]을 더해주면 됨 
a = (((K * arr[0]) + arr[1]) * (M // (K + 1)))
b = arr[0] * (M % (K + 1))

rst = a + b
print(rst)