import sys
import heapq

# python은 기본적으로 최소힙
min_heap = []
max_heap = []


def get_median() -> int:
    if len(min_heap) == len(max_heap):
        return min(min_heap[0], -max_heap[0])

    if len(min_heap) > len(max_heap):
        return min_heap[0]

    return -max_heap[0]


def insert(x: int) -> None:
    min_size = len(min_heap)
    max_size = len(max_heap)

    if max_size == 0:
        heapq.heappush(max_heap, -x)
        return

    if max_size == min_size:
        if x <= get_median(): heapq.heappush(max_heap, -x)
        else: heapq.heappush(min_heap, x)
        return

    if max_size < min_size:
        if x > get_median():
            heapq.heappush(max_heap, -heapq.heappop(min_heap))
            heapq.heappush(min_heap, x)
        else:
            heapq.heappush(max_heap, -x)
        return

    if x < get_median():
        heapq.heappush(min_heap, -heapq.heappop(max_heap))
        heapq.heappush(max_heap, -x)

    else:
        heapq.heappush(min_heap, x)


if __name__ == "__main__":
    input = sys.stdin.readline

    n = int(input())
    for _ in range(n):
        x = int(input())
        insert(x)
        print(get_median())