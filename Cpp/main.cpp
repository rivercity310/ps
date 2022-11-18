// #define SORTING
#define GREEDY
// #define BINARY_SEARCH

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
extern void boj_1931();
#endif

#ifdef BINARY_SEARCH
extern void bin_search_test();
extern void find_part_test1();
extern void find_part_test2();
extern void cutting_rice_cake_test();
#endif

int main() {
    boj_1931();
}   