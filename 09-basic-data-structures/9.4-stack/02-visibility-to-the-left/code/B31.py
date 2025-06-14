class Stack:
    def __init__(self):
        self.array = []

    def push(self, item):
        self.array.append(item)

    def pop(self):
        return self.array.pop()

    def size(self):
        return True if self.array else False
    
    def back(self):
        if self.size():
            return self.array[-1]
        else:
            return False

arr = Stack()
n = int(input())
strings = list(map(int, input().split()))
result = [0] * n

for i in range(n):
    while arr.size() and strings[i] > arr.back()[0]:
        elem, num = arr.pop()
        result[i] += result[num] + 1

    arr.push((strings[i], i))

print(*result)