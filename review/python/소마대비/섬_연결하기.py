def solution(n, costs):
    sorted(costs, key=lambda x: x[2])
    parent = [i for i in range(n)]
    ans = 0

    for cost in costs:
        start = cost[0]
        end = cost[1]
        weight = cost[2]

        if findParent(parent, start) != findParent(parent, end):
            unionParent(parent, start, end)
            ans += weight

    return ans


def findParent(parent, x):
    if parent[x] != x:
        return findParent(parent, parent[x])
    return x


def unionParent(parent, a, b):
    a = findParent(parent, a)
    b = findParent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b
