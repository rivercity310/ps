// ----------------------------------------------------------------------------------

// #define BEGINNER
// #define INTERMEDIATE
// #define PROGRAMMERS
#define SAMSUNG
#define WANTED

// ----------------------------------------------------------------------------------

#ifdef BEGINNER
#define SORTING
#define GREEDY
#define BINARY_SEARCH
#define GRAPH_SEARCH
#define SHORTEST_PATH
#define MST
#define TREE
#define DIVIDE_AND_CONQUER
#define DP
#define OTHERS
#define BACKTRACKING
#endif

// ----------------------------------------------------------------------------------

#ifdef BEGINNER

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

#ifdef GRAPH_SEARCH
extern void boj_24479();
extern void boj_24445();
extern void maze_escape_test();
extern void boj_7562();
extern void boj_7576();
extern void boj_7569();
extern void boj_16928();
#endif

#ifdef SHORTEST_PATH
extern void boj_1916();
extern void boj_1753();
extern void boj_13549();
extern void telegram();
extern void floyd_warshall();
extern void boj_1504();
#endif

#ifdef MST
extern void boj_1956();
#endif

#ifdef TREE
extern void boj_11725();
extern void boj_9934();
#endif

#ifdef DIVIDE_AND_CONQUER
extern void boj_1992();
extern void boj_1629();
extern void boj_1629_with_dp();
#endif

#ifdef DP
extern void boj_9184();
extern void boj_11726();
extern void boj_2133();
extern void boj_14852();
extern void boj_2294();
#endif

#ifdef OTHERS
extern void boj_1018();
extern void boj_2504();
extern void boj_2740();
extern void boj_3273();
extern void boj_1004();
extern void boj_2477();
extern void boj_9613();
extern void boj_1850();
#endif

#ifdef BACKTRACKING
extern void boj_9663();
extern void boj_14888();
extern void boj_14889();
extern void boj_2580();
#endif

#endif


// ----------------------------------------------------------------------------------


#ifdef INTERMEDIATE
extern void boj_1655();
extern void boj_1956();
extern void boj_1167();
extern void boj_2470();
extern void boj_10986();
extern void boj_10830();
extern void boj_10830_with_dp();
extern void boj_9370();
extern void boj_11437();
extern void boj_11438();
#endif


#ifdef PROGRAMMERS
extern void internship_ex1();
extern void internship_ex2();
extern void internship_ex3();

extern void bl2018_ex1();
extern void bl2021_ex1();
extern void bl2022_ex1();

extern void backend_ex1();
#endif

#ifdef WANTED
extern void ex1();
extern void ex2();
extern void ex3();

extern void v1();
extern void v2();
extern void v3();
#endif

// --------------------------------------------------------------------------------------

#ifdef SAMSUNG
extern void solution1();
#endif

int main() {
    v1();
}