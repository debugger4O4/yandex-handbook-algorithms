## Рейтинг в шахматном турнире.

```
Ограничение времени 1 с
Ограничение памяти 256.0 Мб
Ввод стандартный ввод или input.txt
Вывод стандартный вывод или output.txt
```

Даны `m` партий в шахматном турнире. В каждой известен победитель. Требуется определить, возможно ли однозначно определить
уровень игрока?

Будем считать, что у каждого игрока есть свой уникальный скрытый уровень. Игрок с большим уровнем всегда побеждает игрока
с меньшим уровнем.

### Формат ввода.
В первой строке задано два числа ``n``, ``m`` — количество участников турнира и количество партий.

В следующих ``m`` строках заданы партии в формате ``u_i``, ``v_i``, ``t_i`` — номера игроков и победитель в партии.

### Формат вывода.
В единственной строке вывести `YES`, если однозначно можно определить уровень игроков и `NO`, иначе.