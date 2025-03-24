import sys

sys.setrecursionlimit(10000)
def partition(a, left, right):
    v = a[(left + right) // 2][0]
    i = left
    j = right
    while i <= j:
        while a[i][0] < v:
            i += 1
        while a[j][0] > v:
            j -= 1
        if i >= j:
            break
        a[i], a[j] = a[j], a[i]
        i += 1
        j -= 1
    return j
def quicksort(a, left, right, k = 1):
    pivot = (left + right) // 2
    a[pivot][0] = k
    if left < right:
        q = partition(a, left, right)
        quicksort(a, left, q, k + 1)
        quicksort(a, q + 1, right, k)
n = int(input())
a = [[0, m] for m in range(n, 0, -1)]
quicksort(a, 0, n - 1)
a.sort(key = lambda x: x[1])
b = [i[0] for i in a]
print(*b)
