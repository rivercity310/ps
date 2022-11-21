class Node:
    def __init__(self, left, key, right):
        self.left = left
        self.key = key
        self.right = right


def solve(node: Node, key: int) -> Node:
    if node == None:
        return None

    if node.key == key:
        return node

    elif node.key > key:
        return solve(node.right, key)
    else:
        return solve(node.left, key)


if __name__ == '__main__':
    node1 = Node(None, 3, None)
    node2 = Node(None, 5, None)
    root = Node(node1, 4, node2)

    r = solve(root, 5)
    print(r.key)