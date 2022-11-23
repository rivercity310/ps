#include <iostream>
#include <queue>
#include <vector>

using namespace std;

/*
[ 힙을 이용하여 중앙값 구하기 ]
- 새로 들어오는 데이터가 기존 중앙값보다 작거나 같다면 최대힙에, 아니면 최소힙에 저장
- 두 힙의 최상단 원소를 이용하여 중앙값을 계산할 수 있다.

- 지역변수로 priority_queue를 선언하고 참조 매개변수 or 포인터 변수로 함수에 넘기니까 정상적으로 push가 안된다... (?)
- 클래스나 구조체의 멤버변수로 선언해도 정상적으로 push가 안된다 ㅠ...
*/

static priority_queue<int> max_heap;
static priority_queue<int, vector<int>, std::greater<int>> min_heap;

static int get() {
    if (max_heap.size() == min_heap.size())
        return std::min(max_heap.top(), min_heap.top());

    if (max_heap.size() < min_heap.size())
        return min_heap.top();

    return max_heap.top();
}

static void insert(int x) {
    if (max_heap.size() == 0) {
        max_heap.push(x);
        return;
    }

    // 두 힙의 크기가 같을때 : 데이터가 중앙값보다 작거나 같으면 maxheap에, 아니면 minheap에 push
    if (max_heap.size() == min_heap.size()) {
        if (x <= get()) max_heap.push(x);
        else min_heap.push(x);
        return;
    }

    if (max_heap.size() < min_heap.size()) {
        if (x > get()) {
            max_heap.push(min_heap.top());
            min_heap.pop();
            min_heap.push(x);
        }
        else max_heap.push(x);

        return;
    }

    // max_heap.size() > min_heap.size()인 경우
    if (x < get()) {
        min_heap.push(max_heap.top());
        max_heap.pop();
        max_heap.push(x);
    }
    else min_heap.push(x);
}

void boj_1655() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;

        insert(x);
        cout << get() << "\n";
    }
}