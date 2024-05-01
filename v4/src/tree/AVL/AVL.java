package tree.AVL;

public class AVL {
    private TreeNode root;

    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        return node.height;
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    public void insert(int x) {
        root = insert(root, x);
    }

    private TreeNode insert(TreeNode node, int x) {
        if (node == null) return new TreeNode(x);

        if (node.val > x) {
            System.out.println(node.val + " 왼쪽으로 이동");
            node.left = insert(node.left, x);
        }

        else if (node.val < x) {
            System.out.println(node.val + " 오른쪽으로 이동");
            node.right = insert(node.right, x);
        }

        else return node;

        // 데이터가 삽입된 부분부터 높이를 갱신하며 해당 노드의 밸런스를 검사한다.

        // 1. 데이터 삽입 이후 높이 갱신
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);

        // 2. 이후 4가지 균형이 깨진 상황 각각에 대해 회전을 수행한다.
        // (left-left, right-right, left-right, right-left)

        // left-left
        if (balance > 1 && x < node.left.val) {
            System.out.println(node.val + " 기준으로 오른쪽 회전 (left-left)");
            return rightRotate(node);
        }

        // right-right
        if (balance < -1 && x > node.right.val) {
            System.out.println(node.val + " 기준으로 왼쪽 회전 (right-right)");
            return leftRotate(node);
        }

        // left-right
        if (balance > 1 && x > node.left.val) {
            // 왼쪽 자식노드에 대해 좌회전 후 우회전 수행
            System.out.println(node.left.val + " 기준으로 왼쪽 회전 (left-right)");
            node.left = leftRotate(node.left);
            System.out.println(node.val + " 기준으로 오른쪽 회전 (left-right)");
            return rightRotate(node);
        }

        // right-left
        if (balance < -1 && x < node.right.val) {
            // 오른쪽 자식노드에 대해 우회전 후 좌회전 수행
            System.out.println(node.right.val + " 기준으로 오른쪽 회전 (right-left)");
            node.right = rightRotate(node.right);
            System.out.println(node.val + " 기준으로 왼쪽 회전 (right-left)");
            return leftRotate(node);
        }

        // 데이터 삽입 이후에도 밸런스가 깨지지 않은 경우
        return node;
    }

    // parent 노드를 기준으로 왼쪽으로 회전
    // 1. 오른쪽 자식 노드가 새로운 부모가 된다.
    // 2. parent 노드는 새로운 부모 노드의 왼쪽 자식이 된다.
    // 3. 오른쪽 자식 노드의 왼쪽 서브트리는 parent 노드의 오른쪽 서브트리가 된다.
    private TreeNode leftRotate(TreeNode parent) {
        TreeNode newParent = parent.right;
        TreeNode T2 = newParent.left;
        newParent.left = parent;
        parent.right = T2;

        // 회전이 일어난 뒤, 자식 노드가 변경된 노드(parent, newParent)들을 기준으로 새롭게 높이를 계산해주어야 한다.
        // 이때, parent의 높이를 먼저 계산해주어야 한다. (자식부터 계산)
        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        newParent.height = Math.max(getHeight(newParent.left), getHeight(newParent.right)) + 1;
        return newParent;
    }

    private TreeNode rightRotate(TreeNode parent) {
        TreeNode newParent = parent.left;
        TreeNode T2 = newParent.right;
        newParent.right = parent;
        parent.left = T2;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        newParent.height = Math.max(getHeight(newParent.left), getHeight(newParent.right)) + 1;
        return newParent;
    }

    public void delete(int x) {
        this.root = delete(root, x);
    }

    private TreeNode delete(TreeNode node, int x) {
        if (node == null) return null;

        if (x < node.val) node.left = delete(node.left, x);
        else if (x > node.val) node.right = delete(node.right, x);
        else {
            // 삭제 대상 노드가 리프 노드면 바로 삭제
            if (node.left == null && node.right == null) {
                return null;
            }

            else {
                // 왼쪽 자식이 있으면 선행자 노드로 삭제 대상 노드의 값을 대체
                if (node.left != null) {
                    TreeNode target = findSuccessor(node.left);
                    node.val = target.val;
                    node.left = delete(node.left, target.val);
                }

                // 이 경우 자식이 right에만 1개인 경우이므로 자식으로 삭제 대상 노드 대체
                else {
                    node = node.right;
                }
            }
        }

        // 삭제 이후 높이 재정의 (밸런스 검사)
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);

        if (node.left != null) {
            System.out.println(node.left.val);
        }

        // left-left
        if (balance > 1 && x < node.left.val) {
            return rightRotate(node);
        }

        // right-right
        if (balance < -1 && x > node.right.val) {
            return leftRotate(node);
        }

        // left-right
        if (balance > 1 && x > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // right-left
        if (balance < -1 && x < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private TreeNode findSuccessor(TreeNode node) {
        if (node.right != null) return findSuccessor(node.right);
        else return node;
    }

    public void search(int x) {
        search(root, x);
    }

    private void search(TreeNode node, int x) {
        if (node == null) {
            System.out.println("존재하지 않는 데이터");
            return;
        }

        if (node.val == x) {
            System.out.println(node.val + " 발견");
            return;
        }

        if (node.val > x) {
            System.out.println(node.val + " 기준으로 왼쪽 서브트리로 이동");
            search(node.left, x);
        }

        else {
            System.out.println(node.val + " 기준으로 오른쪽 서브트리로 이동");
            search(node.right, x);
        }
    }

    public void preorder() {
        System.out.println("---- 전위순회 결과 ----");
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
}
