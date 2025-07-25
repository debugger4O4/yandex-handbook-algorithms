## Выход из лабиринта: один ключ.

```
Ограничение времени 1 с
Ограничение памяти 256.0 Мб
Ввод стандартный ввод или input.txt
Вывод стандартный вывод или output.txt
```

Задан лабиринт. Лабиринт представляет собой прямоугольник `n` на `m` клеток. Каждая клетка может находится в одном из шести состояний:

* Пустая клетка `...`
* Стена `#`
* Вход в лабиринт `S`
* Выход из лабиринта `F`
* Дверь с замком `D`
* Ключ от двери `K`

Гарантируется, что в лабиринте один вход, один выход, одну дверь и один ключ. Также гарантируется, что контур лабиринта состоит из стены.

Изначально Вы находитесь в стартовой клетке. Вы можете двигаться:
* вверх `U`
* вниз `D`
* вправо `R`
* влево `L`
* подобрать ключ `P`

Только после того, как ключ подобран, есть возможность попасть в клетку `D`. Подобрать ключ можно только один раз.

Требуется вывести кратчайший выход из лабиринта с помощью символов `UDRLP`.

Если выйти из лабиринта невозможно, то выведите `-1`.

### Формат ввода.
В первой строке заданы два числа ``n``, ``m``.

В следующих ``n`` строках задан лабиринт.

### Формат вывода.
Если выйти из лабиринта невозможно, то выведите единственное число ``−1``.

Если же выход из лабиринта существует, то в первой строке выведите кратчайшее расстояние до выхода, а во второй сам путь.