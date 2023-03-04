# 1이 될때까지
# 1을 빼거나 k로 나누어 1을 만드는 최소 횟수
# 나누기는 나누어떨어질 때만 가능

n, k = map(int, input().split())
cnt = 0

while (n != 1):
    if n % k == 0:
        n /= k
    else:
        n -= 1
    
    cnt += 1

print(cnt)