## Выполнение операций со словарем.

```
Ограничение времени 1 с
Ограничение памяти 256.0 Мб
Ввод стандартный ввод или input.txt
Вывод стандартный вывод или output.txt
```

Изначально у вас есть пустой словарь. Далее вам поступает `q` запросов. Каждый запрос одного из следующих типов:

- Запрос 1-ого типа: поставить в соответствие ключу `x` число `y`;
- Запрос 2-ого типа: проверить, какое число соответствует ключу `x`.

Считайте, что изначально каждому ключу соответствует число `−1`.

### Формат ввода.
Первая строка содержит единственное число `q` -- количество запросов.

Далее следует `q` строк. Каждая из этих строк может иметь один из следующих видов:

Для запроса первого типа -- "1 x y" (без кавычек).
Для запроса второго типа -- "2 x" (без кавычек).

### Формат вывода.
Вывод должен состоять из `count` строк, где `count` -- количество запросов второго типа. Каждая строка должна содержать 
одно число, которое соответствует ключу.

## Огарничения.
Ограничения:
- `1 ≤ q ≤ 1⋅10^5`;
- Для запросов первого типа выполнено `1 ≤ x, y ≤ 10^9`;
- Для запросов второго типа выполнено `1 ≤ x ≤ 10^9`.