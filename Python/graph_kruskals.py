import time
from collections import defaultdict

class Graph:
    def __init__(self, V):
        self.V = V
        self.graph = []
    def addEdge(self, u, v, w):
        self.graph.append([u, v, w])
    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent , parent[i])
    def union(self, parent, rank, x, y):

        xroot = self.find(parent , x)
        yroot = self.find(parent , y)
        
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot

        elif rank[xroot]> rank[yroot]:
            parent[yroot] = xroot

        else:
            parent[yroot] = xroot
            rank[xroot] +=1

    def KruskalMST(self):
        i = 0
        e = 0
        parent =[]
        rank =[]
        result = []
        self.graph = sorted(self.graph , key= lambda item:item[2])
        for node in range(self.V):
            parent.append(node)
            rank.append(0)
       
        while e< self.V-1:
            u, v, w = self.graph[i]
            i = i+1
            x = self.find(parent, u)
            y = self.find(parent, v)

            if x != y:
                e = e+1
                result.append([u, v, w])
                self.union(parent, rank, x, y)

        print(f"Edges in Kruskal's MST are")
        minCost = 0
        for u, v, w in result:
            print("%d -- %d == %d"%(u,v,w))
            minCost += w
        print("Minimum cost =",minCost)
n = int(input("Enter number of vertices of the graph "))
g = Graph(n)
x = int(input("Enter number of edges in the graph "))
arr = [None]* 3
for i in range(x):
    print("Enter starting vertex, ending vertex and weight of edge {} ".format(i+1))
    for j in range(3):
        arr[j] = int(input())
    g.addEdge(arr[0], arr[1], arr[2])
start = time.time()
g.KruskalMST()
end = time.time()
print(end = "\n")
print(f"Runtime of Kruskal's algorithm is {(end-start)*1000} milliseconds")
            