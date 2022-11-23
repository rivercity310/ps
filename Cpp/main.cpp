// #define SORTING
// #define GREEDY
// #define BINARY_SEARCH
#define SHORTEST_PATH

#ifdef SORTING
extern void selection_sort_test();
extern void bubble_sort_test();
extern void insertion_shell_sort_test();
extern void quick_sort_test();
extern void merge_sort_test();
extern void count_sort_test();
extern void boj_18870();
extern void boj_2108();
extern void boj_24060();
#endif

#ifdef GREEDY
extern void big_number_test();
extern void card_game_test();
extern void exchange_test();
extern void number_one_test();
extern void boj_1931();
extern void boj_13305();
#endif

#ifdef BINARY_SEARCH
extern void bin_search_test();
extern void find_part_test1();
extern void find_part_test2();
extern void cutting_rice_cake_test();
extern void boj_1654();
extern void boj_2805();
extern void boj_2110();
extern void boj_2110_c();
extern void lower_and_upper_bound_test();
#endif

#ifdef SHORTEST_PATH
extern void boj_1916();
extern void boj_1753();
extern void boj_13549();
extern void telegram();
#endif

int main() {
    telegram();
}   