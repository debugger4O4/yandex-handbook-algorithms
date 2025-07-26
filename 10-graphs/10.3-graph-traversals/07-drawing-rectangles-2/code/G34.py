from sys import stdin
data = stdin.read().split()
ind = 0
output_answer = []
test = []
k_max = 9
t = (int(data[ind]))
ind += 1
for _ in range(t):
    n = int(data[ind])
    m = int(data[ind + 1])
    k = int(data[ind + 2])
    s = int(data[ind + 3])
    ind += 4
    desktop = []
    for i in range(n):
        desktop.append(data[ind])
        ind += 1
    test.append((n, m, k, s, desktop))

for n, m, k, s, desktop in test:
    program_place_on_desktop = [[] for _ in range(k_max + 1)]
    for row in range(n):
        for col in range(m):
            current_block = desktop[row][col]
            if current_block != '.':
                program_place_on_desktop[int(current_block)].append((row, col))

    window = [[] for _ in range(k + 1)]
    for program in range(1, k + 1):
        programm_row, programm_col = program_place_on_desktop[program][0]
        for row in range(s):
            for col in range(s):
                check_row = programm_row - row
                check_col = programm_col - col
                if 0 <= check_row and 0 <= check_col:
                    check_left_point = True
                    for x, y in program_place_on_desktop[program]:
                        if not ((check_row <= x <= check_row + (s - 1)) and (check_col <= y <= check_col + (s - 1))):
                            check_left_point = False
                            break
                    if check_left_point:
                        temp = set()
                        isBreak = False
                        for i in range(s):
                            if isBreak:
                                break
                            for j in range(s):
                                point_row_square = check_row + i
                                point_col_square = check_col + j

                                if point_row_square >= n or point_col_square >= m or desktop[point_row_square][point_col_square] == '.':
                                    temp = set()
                                    isBreak = True
                                    break
                                temp.add(desktop[point_row_square][point_col_square])
                        if temp:
                            window[program].append(temp)
    this_result = 0
    maximum = (n * m) + 10000
    queue = [0] * maximum
    queue_front = 0
    queue_back = 0
    remaining_nums_dict = dict()

    dict_num_set = {'1': {'1'}, '2': {'2'}, '3': {'3'}, '4': {'4'}, '5': {'5'}, '6': {'6'}, '7': {'7'}, '8': {'8'}, '9': {'9'}}
    for digit in range(1, k + 1):
        str_digit = set(str(digit))
        num = ''.join(str(i) for i in range(1, k + 1) if i != digit)
        remaining_nums_dict[num] = [dict_num_set[str(digit)], len(window[digit]), num]
        queue[queue_back] = num
        queue_back = (queue_back + 1) % maximum
    while queue_back != queue_front:
        path, mul, numbers = remaining_nums_dict[queue[queue_front]]
        queue_front = (queue_front + 1) % maximum
        if len(path) >= k:
            this_result += mul
        else:
            for number in numbers:
                    common_path = ''
                    common_mul = 0
                    for option in window[int(number)]:
                        if not option.intersection(path):
                            if not common_path:
                                common_path = path.union(dict_num_set[number])
                            common_mul += mul
                    if common_path:
                        now_numbers = numbers.replace(number, '', 1)
                        if now_numbers not in remaining_nums_dict:
                            remaining_nums_dict[now_numbers] = [common_path, common_mul, now_numbers]
                            queue[queue_back] = now_numbers
                            queue_back = (queue_back + 1) % maximum
                        else:
                            remaining_nums_dict[now_numbers][1] += common_mul

    output_answer.append(this_result)

print('\n'.join(str(i) for i in output_answer))