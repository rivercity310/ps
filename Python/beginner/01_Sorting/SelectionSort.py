n = 10
arr = list(map(int, input().split()))

def selection_sort():
    # global arr : 함수내 동일한 arr이 있을 때, 전역변수 arr 사용 명시, 단순히 상위 스코프에서 찾으려면 nonlocal

    for i in range(n - 1, 0, -1):       # 역 for문
        max_index = -int(1e9)
        max_elem = -int(1e9)

        for j in range(0, i + 1):
            if arr[j] > max_elem:
                max_elem = arr[j]
                max_index = j

        print("%d <--> %d" % (arr[max_index], arr[i]))
        arr[i], arr[max_index] = arr[max_index], arr[i]

    print("[정렬 후 배열]")
    print(*arr)


# visited 방문처리 배열을 이용
def solution():
    global n

    ans = [""] * n
    visited = [False] * n
    grades = ["A+", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"]
    cnt = 0

    for i in range(n - 1, -1, -1):
        max_index = -int(1e9)
        max_elem = -int(1e9)

        for j in range(n):
            if arr[j] > max_elem and not visited[j]:
                max_elem = arr[j]
                max_index = j
        
        visited[max_index] = True
        ans[max_index] = grades[cnt]
        cnt += 1    
    
    print("[성적 부여 결과]")
    print(*ans)


def solution2():
    global n

    ans = [""] * n
    grades = ["A+", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"]
    cnt = 0

    for i in range(n - 1, -1, -1):
        max_elem = -int(1e9)
        max_index = -int(1e9)

        for j in range(n):
            if arr[j] > max_elem:
                max_elem = arr[j]
                max_index = j

        ans[max_index] = grades[cnt]
        cnt += 1

        arr[max_index] = -int(1e9) - 1
        
    print("[성적 부여 결과]")
    print(*ans)

solution2()