def solution(n, K, m, Q):
    result = []
    for i in Q:
        min_idx = 0
        max_idx = n - 1
        min_seq = -1
        while max_idx >= min_idx:
            mid_idx = (max_idx + min_idx) // 2
            if K[mid_idx] == i:
                max_idx = mid_idx - 1
                min_seq = mid_idx
            elif K[mid_idx] > i:
                max_idx = mid_idx - 1
            else:
                min_idx = mid_idx + 1
        min_idx = min_seq
        max_idx = n - 1
        max_seq = min_seq
        while min_seq != -1 and max_idx >= min_idx:
            mid_idx = (max_idx + min_idx) // 2
            if K[mid_idx] == i:
                min_idx = mid_idx + 1
                max_seq = mid_idx
            elif K[mid_idx] > i:
                max_idx = mid_idx - 1
            else:
                min_idx = mid_idx + 1
        if min_seq == -1:
            result.append(0)
        else:
            result.append(max_seq - min_seq + 1)
    return result

n = int(input())
K = list(map(int, input().split()))
m = int(input())
Q = list(map(int, input().split()))

print(*solution(n, K, m, Q))