### Алгоритм нахождения компонент связности в графе.

Алгоритмы поиска в глубину и ширину находят широкое применение и могут использоваться в других алгоритмах. Рассмотрим один
из таких алгоритмов для поиска компонент связности в графе. Под компонентой связности в графе понимают множество вершин 
графа достижимых попарно и рёбра их связывающие. Для поиска компонент связности необходимо из каждой не посещённой вершины
запускать алгоритм обхода, накапливая результаты каждого в отдельный контейнер. Пример ниже поможет понять алгоритм.

![algosy_10_4_d79d964028_9947900ea3.gif](content%2Falgosy_10_4_d79d964028_9947900ea3.gif)

Асимптотическая сложность нахождения компонент связности в графе — `O(V+E)`, где `V` — число вершин, а `E` — число рёбер и дуг.