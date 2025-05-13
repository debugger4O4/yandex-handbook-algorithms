from sys import stdin
from collections import deque 

s = stdin.readline().rstrip()
postfix_expression = []
queue = deque()

storage = 0
isNumber = False
for sym in s:
    if sym.isdigit():
        storage = storage * 10 + int(sym)
        isNumber = True
    else:
        if isNumber:
            postfix_expression.append(storage)
            isNumber = False
            storage = 0
        
        if sym == '*' and queue and queue[0] == '*':
            while queue[0] != '*':
                postfix_expression.append(queue.popleft())
        elif sym == '+' or sym == '-':
            while queue and queue[0] != '(':
                postfix_expression.append(queue.popleft())   
        elif sym == ')':
            while queue[0] != '(':
                postfix_expression.append(queue.popleft())
            queue.popleft()
            continue
        queue.appendleft(sym)
if isNumber:           
    postfix_expression.append(storage)
while queue:
    postfix_expression.append(queue.popleft())
for operand in postfix_expression:
    if isinstance(operand, int):
        queue.appendleft(operand)
    else:
        num_2 = queue.popleft()
        num_1 = queue.popleft()
        queue.appendleft(eval(f'{num_1}{operand}{num_2}'))

answer = 0
if queue:
    answer = queue.popleft()
print(answer)