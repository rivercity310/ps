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
extern void big_number_test();
extern void card_game_test();
extern void exchange_test();
extern void number_one_test();
#endif

#ifdef BINARY_SEARCH

#endif

int main() {
    number_one_test();
}   