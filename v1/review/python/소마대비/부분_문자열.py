import sys

while True:
    try:
        s, t = sys.stdin.readline().split()

        left = 0
        chk = False

        for c in t:
            if c == s[left]:
                left += 1

            if left == len(s):
                chk = True
                break

        print("Yes" if chk else "No")

    except:
        break
