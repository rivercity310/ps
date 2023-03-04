import sys

input = sys.stdin.readline 

def get_avgs(n: int, nums: list) -> int:
    return int(round(sum(nums) / n, 0))

def get_middle(n: int, nums: list) -> int:
    return sorted(nums)[n // 2]

def get_frequently_num2(n: int, nums: list) -> int:
    if n == 1:
        return nums[0]

    size = 4001
    fq_minus = [0] * size
    fq_plus = [0] * size

    for k in nums:
        if k < 0: fq_minus[-k] += 1
        else: fq_plus[k] += 1

    most_val = max(max(fq_minus), max(fq_plus))
    is_minus = False
    is_second = 0

    for i in range(size - 1, 0, -1):
        if fq_minus[i] == most_val:
            if is_second == 1:
                return -i

            is_minus = True
            tmp = i
            is_second += 1

    for i in range(size):
        if fq_plus[i] == most_val:
            if is_second == 1:
                return i

            is_minus = False
            tmp = i
            is_second += 1

    if is_minus: return -tmp
    else: return tmp

def get_frequently_num(n: int, nums: list) -> int:
    if n == 1:
        return nums[0]

    dict = {}

    for num in nums:
        if num not in dict:
            dict[num] = 1
        else:
            dict[num] += 1

    print(dict.items())
    sort_dict = sorted(dict.items(), key=lambda x: (x[1], -x[0]), reverse=True)
    print(sort_dict)

    return sort_dict[1][0] if sort_dict[0][-1] == sort_dict[1][-1] else sort_dict[0][0]

def get_range(nums: list) -> int:
    return max(nums) - min(nums)

def solve(n: int, nums: list):
    print(get_avgs(n, nums))
    print(get_middle(n, nums))
    print(get_frequently_num2(n, nums))
    print(get_range(nums))

if __name__ == '__main__':
    n = int(input())
    nums = [int(input()) for _ in range(n)]

    solve(n, nums)
    

