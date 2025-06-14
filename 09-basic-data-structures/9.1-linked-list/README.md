### Односвязный список.

Односвязный список (иногда «связный список») — базовая структура данных, представляющая собой соединённые узлы с однотипными
данными. Каждый узел состоит из элемента и ссылки на следующий элемент (см. рисунок).

Самый первый элемент списка называют головой (`head`) односвязного списка, а последний — хвостом (`tail`). Последний элемент
односвязного списка в качестве ссылки содержит `null`-значение.

![img.png](content%2Fimg.png)

В отличие от классического массива, где данные в памяти расположены строго последовательно, в односвязном списке, наоборот,
данные расположены хаотично и связывание узлов списка происходит посредством ссылок. За счёт этой особенности в односвязный
список можно добавлять произвольное число элементов, однако, доступ будет осуществляться только последовательно. Произвольного
доступа к элементам в односвязном списке нет.

Со списком можно производить ряд операций:
- Добавить элемент (`add`).
- Удалить элемент (`remove`).
- Найти элемент (`find`).
- Посчитать количество элементов по условию (`count`).

Операция добавления элемента (`add`) может быть представлена в нескольких вариантах. Элемент можно добавить в начало списка,
можно добавить в конец списка или после определённого элемента. Перед добавлением элемента необходимо создать узел, положив4
в него заданное значение, затем связать ссылку со списком. В случае добавления в начало списка ссылка нового узла будет 
указывать на голову списка, а голова списка должна быть перемещена на новый узел. Если добавление идёт в конце списка, то 
ссылка хвоста списка должна указывать на новый узел, а после должна быть перемещена на новый узел. Сложность этих операций —
`O(1)`.

Удаление элемента (`remove`) предполагает, что будет найден заданный элемент и следом он будет удалён. Нахождения узла требует
прохода по односвязному списку, после чего необходимо ссылку с элемента перед удаляемым перенаправить на элемент после удаляемого.
Сложность операции — `O(n)`, где `n` — число элементов в списке.

Нахождение элемента (`find`) предполагает простой однократный проход по списку с нахождением ссылки на заданный элемент. 
Сложность операции — `O(n)`, где `n` — число элементов в списке.

Подсчёт числа элементов по условию (count) предполагает проход по списку и сравнение всех элементов с заданным с подсчётом
количества удовлетворяющих условию элементов. Сложность операции — `O(n)`, где `n` — число элементов в списке.

### Примечание
Пусть `sizei` -- размер списка в момент `i`-ого запроса.

Ограничения:
- `1 ≤ q ≤ 5 ⋅ 10^3`
- Для запросов первого типа `0 ≤ x ≤ sizei` и `1 ≤ y ≤ 10^6`.
- Для запросов второго типа `1 ≤ x ≤ sizei`
- Для запросов третьего типа `1 ≤ x ≤ sizei`
