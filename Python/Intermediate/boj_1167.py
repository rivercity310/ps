import sys
import heapq


# start 정점으로부터 가장 먼 정점을 반환
def dijkstra(grp: list[list[tuple]], start) -> int:
    pq = []
    distance = [int(1e9)] * len(grp)

    heapq.heappush(pq, (0, start))
    distance[start] = 0;

    while pq:
        dist, now = heapq.heappop(pq)

        if distance[now] < dist:
            continue

        for end, weight in grp[now]:
            cost = distance[now] + weight

            if distance[end] > cost:
                distance[end] = cost
                heapq.heappush(pq, (cost, end))

    max_elem = 0
    max_node = 0
    for idx, val in enumerate(distance):
        if val == int(1e9):
            continue

        if val > max_elem:
            max_elem = val
            max_node = idx

    return max_elem, max_node


def solve(grp: list[list[tuple]]) -> None:
    _, max_node = dijkstra(grp, 1)
    ans, _ = dijkstra(grp, max_node)

    print(ans)


if __name__ == "__main__":
    input = sys.stdin.readline
    v = int(input())

    grp = [[] for _ in range(v + 1)]
    for _ in range(v):
        tmp = list(map(int, input().split()))[:-1]

        node = tmp[0]
        size = len(tmp) // 2
        idx = 0

        while size:
            grp[node].append((tmp[1 + idx], tmp[2 + idx]))
            idx += 2
            size -= 1

    solve(grp)