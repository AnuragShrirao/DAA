import timeit

class Graph():

    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]

    def printSolution(self, dist):
        print ("Vertex \tDistance from Source")
        for node in range(self.V):
            print ("  ", node, "\t\t\t", dist[node])

    def minDistance(self, dist, sptSet):

        min = 99999999

        for v in range(self.V):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v

        return min_index

    def dijkstra(self, src):

        dist = [99999999] * self.V
        dist[src] = 0
        sptSet = [False] * self.V

        for _ in range(self.V):

            u = self.minDistance(dist, sptSet)

            sptSet[u] = True

            for v in range(self.V):
                if self.graph[u][v] > 0 and sptSet[v] == False and \
                        dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]

        self.printSolution(dist)


n = int(input("Enter the no of vertex: "))
g = Graph(n)
print(f"Enter the adjacency matrix of {n}x{n}: ")
g.graph = [list(map(int, input().split())) for _ in range(n)]

s = timeit.default_timer()
g.dijkstra(0);
e = timeit.default_timer()

print("\nExecution time is {} seconds".format(e-s))