import timeit

def travelling_salesman_problem(graph, s, V):
    vertex = []
    for i in range(V):
        if i != s:
            vertex.append(i)

    # home city
    current_node = s
    total_min_dist = 0
    print("\nPath is: ", end="")
    while vertex:
        min_dist = 999999999999
        print(current_node, end=" ")
        # find shortest distance
        for i in vertex:
            if min_dist > graph[current_node][i]:
                node = i
                min_dist = graph[current_node][i]
        total_min_dist += min_dist

        # update the current node
        current_node = node
        vertex.remove(current_node)

    print(current_node, source, end=" ")
    # add distance from current city to home city
    total_min_dist += graph[current_node][s]

    return total_min_dist


source = int(input("Enter the source vertex: "))
V = int(input("Enter the no of  vertex: "))
print(f"Enter the matrix of {V}x{V}: ")
graph = [list(map(int, input().split())) for _ in range(V)]

s = timeit.default_timer()
print("\nMinimum path distance is : ", travelling_salesman_problem(graph, source, V))
e = timeit.default_timer()

print("\nExecution time is {} seconds".format(e-s))