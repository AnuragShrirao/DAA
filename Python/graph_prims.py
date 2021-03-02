import sys
import time

class Graph:
    def __init__(self,vertices):
        self.V = vertices
        self.graph = [[0 for row in range(vertices)]for column in range(vertices)]

    def printMST(self, parent):
        minCost = 0
        print("\nThe edges in minimum spanning tree of given graph are\n")
        print("Edge\tWeight")
        for i in range(1, self.V):
            print(parent[i], "--", i,"\t" , self.graph[i][parent[i]])
            minCost += self.graph[i][parent[i]]

        print(f"Minimum cost of spanning tree by Prim's algorithm is =", minCost)

    def minKey(self, key, mstSet):

        min = sys.maxsize

        for v in range(self.V):
            if key[v]< min and mstSet[v] == False:
                min = key[v]
                min_index = v

        return min_index

    def primMST(self):

        key = [sys.maxsize] * self.V
        parent = [None]* self.V
        mstSet = [False]* self.V
        key[0] = 0
        parent[0] = -1

        for x in range(self.V):
            u = self.minKey(key, mstSet)

            mstSet[u] = True

            for v in range(self.V):
                if self.graph[u][v] > 0 and key[v]> self.graph[u][v] and mstSet[v] == False:
                    key[v] = self.graph[u][v]
                    parent[v] = u

        self.printMST(parent)

n = int(input("Enter number of vertices of the graph "))
g = Graph(n)
print("Enter the adjacency matrix of the Graph \n")
for i in range(n):
    print("Enter", n ,"values in row",i+1)
    for j in range(n):
        g.graph[i][j]=int(input())

start = time.time()
g.primMST()
end = time.time()
print(end = "\n")
print(f"Runtime of Prims's algorithm is {(end-start)*1000} milliseconds")












        
