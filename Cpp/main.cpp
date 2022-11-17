#define SORTING
#define GREEDY
#define BINARY_SEARCH

#ifdef SORTING
extern void selection_sort_test();
extern void insertion_sort_test();
extern void quick_sort_test();
extern void count_sort_test();
#endif

#ifdef GREEDY

#endif

#ifdef BINARY_SEARCH

#endif

int main() {
    count_sort_test();
}