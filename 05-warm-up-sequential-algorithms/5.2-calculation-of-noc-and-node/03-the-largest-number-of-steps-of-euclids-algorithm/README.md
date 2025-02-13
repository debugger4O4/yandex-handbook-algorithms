## Наибольшее число шагов алгоритма Евклида.

```
Ограничение времени 1 с
Ограничение памяти 256.0 Мб
Ввод стандартный ввод или input.txt
Вывод стандартный вывод или output.txt
```

Алгоритм Евклида можно записать в рекурсивной форме:
```
GCD(a, b):
    if a = 0 or b = 0:
        return max(a,b)
    return GCD(b,a mod b)
```
Вызов функции `GCD(5, 0)` не порождает дополнительных рекурсивных вызовов. А вызов `GCD(5, 2)` --- порождает вызовы `GCD(2, 1)` 
и `GCD(1, 0)`.

Количество шагов алгоритма Евклида будет равняться количеству вызовов функции `GCD` для заданных значений `a` и `b`.

Дано число `n`, найдите значения `a` и `b(0 ≤ a, b ≤ n)`, для которых количество вызовов функции `GCD` будет наибольшим.

### Формат ввода.
Целое число `n`.

Ограничения: `1 ≤ n ≤ 10^9`.

### Формат вывода.
Значения `a` и `b`(разделеённые пробелом).

Если существует несколько пар значений `a` и `b`, для которых количество вызовов функции `GCD` наибольшее, то выведите 
любую из таких пар.