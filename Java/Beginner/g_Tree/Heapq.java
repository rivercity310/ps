package Beginner.g_Tree;

class Heap {
    private int size;
    private int[] heap;

    public Heap(int max) {
        this.heap = new int[max];
        this.size = 0;
    }

    public void insert_heap(int data) {
        int i = ++size;

        while ((i != 1) && data > heap[i / 2]) {
            heap[i] = heap[i / 2];
            i /= 2;
        }

        heap[i] = data;
    }

    public int delete_heap() {
        int root = heap[1];
        int last = heap[size--];
        int parent = 1;
        int child = 2;

        while (child <= size) {
            if (child < size && heap[child] < heap[child + 1]) child++;
            if (last >= heap[child]) break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }

        heap[parent] = last;
        return root;
    }

    public int peek_heap() {
        return heap[1];
    }
}

public class Heapq {
    public static void main(String[] args) {
        Heap h = new Heap(100);

        for (int i = 1; i < 100; i++) h.insert_heap(i);
        System.out.println("Heap Peek: " + h.peek_heap());
        for (int i = 99; i >= 1; i--) System.out.printf("%d ", h.delete_heap());
    }
}