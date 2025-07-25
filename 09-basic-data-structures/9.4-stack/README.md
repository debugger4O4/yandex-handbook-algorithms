### Стек.

Стек (`stack`) — структура данных, которая работает по принципу «последним пришёл, первым ушёл» (`LIFO — last in, first out`). 
Стек можно представить как некий контейнер, в котором элементы (например, числа, символы и так далее) могут быть добавлены
в вершину, а затем извлечены только из вершины. В бытовом плане стек напоминает стопку тарелок. Тогда тарелка, которую 
положили первой, в самый низ, будет использована последней.

Существуют различные реализации стека. Например, стек может быть реализован на массиве, на односвязном списке, на двусвязном
списке и так далее. В параграфе будем говорить о реализации стека на односвязном списке.

Основные операции, которые можно производить со стеком, включают:

- Добавление элемента в вершину стека (`push`) — `O(1)`.
- Удаление элемента из вершины стека (`pop`) —  `O(1)`.
- Возврат верхнего элемента без его удаления (`peek`) — `O(1)`.
- Проверка стека на пустоту (`isEmpty`) — `O(1)`.

Стоит отметить, что стек представляет собой список с элементами и указателя на вершину стека, указывающего на последний 
элемент, добавленный в стек.

Каждый раз, когда в стек добавляется новый элемент, указатель на вершину смещается на следующий элемент. Когда элемент 
удаляется из вершины стека, указатель смещается на предыдущий элемент. Если указатель находится в конце стека, то стек пуст.
