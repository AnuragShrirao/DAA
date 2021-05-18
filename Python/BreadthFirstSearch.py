from collections import defaultdict
import timeit

class Graph:

    def __init__(self):

        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def bfs(self, s):

        visited = [False] * (max(self.graph) + 1)

        queue = [s]

        visited[s] = True

        while queue:
            s = queue.pop(0)
            print(s, end=" ")

            for i in self.graph[s]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True


g = Graph()

n = int(input("Enter the no of edge in graph: "))

source_vertex = int(input("Enter the source vertex: "))

vertex = int(input("Enter the vertex: "))

print("Enter the edges: ")
for i in range(n):
    g.add_edge(*list(map(int, input().split())))

print("The nodes are: ")
s = timeit.default_timer()
g.bfs(source_vertex)
e = timeit.default_timer()

print("\nExecution Time is ", (e-s))