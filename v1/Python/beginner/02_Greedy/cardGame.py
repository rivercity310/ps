# 숫자 카드 게임
# 주어진 N x M 행렬에서 행 선택 -> 행에서 가장 낮은 숫자가 선택됨
# 최종적으로 가장 높은 숫자

N, M = map(int, input().split())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

ans = 0
for i in range(N):
    k = min(arr[i])     # 행에서 가장 작은 숫자
    ans = max(ans, k)

print(ans)
