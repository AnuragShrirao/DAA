from collections import defaultdict
import timeit


class Graph:

    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def adding_neighbour(self, v, visited):

        visited.add(v)
        print(v, end=' ')

        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.adding_neighbour(neighbour, visited)
                
    def dfs(self, v):

        visited = set()

        self.adding_neighbour(v, visited)


g = Graph()

n = int(input("Enter the no of edge in graph: "))

source_vertex = int(input("Enter the source vertex: "))

vertex = int(input("Enter the vertex: "))

print("Enter the edges: ")
for i in range(n):
    g.add_edge(*list(map(int, input().split())))

print("The nodes are: ")
s = timeit.default_timer()
g.dfs(source_vertex)
e = timeit.default_timer()

print("\nThe time taken by Heap sort to sort the given array is: ", (e-s))

"""
6
2
0 1
0 2
1 2 
2 0 
2 3 
3 3
"""
