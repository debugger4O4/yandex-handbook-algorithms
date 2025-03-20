def solution(n, K, m, Q):
    result = []
    for i in (Q):
        min = 0
        max = n - 1
        res = -1
        while max >= min:
            mid = (min + max) // 2
            if K[mid] == i:
                res = mid
                break
            elif K[mid] > i:
                max = mid - 1
            else:
                min = mid + 1
        result.append(res)
    return result

n = int(input())
K = list(map(int, input().split()))
m = int(input())
Q = list(map(int, input().split()))

for i in solution(n, K, m, Q):
    print(i)