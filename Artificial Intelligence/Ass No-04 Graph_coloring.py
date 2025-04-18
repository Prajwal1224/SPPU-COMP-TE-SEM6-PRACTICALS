def add_edge(graph, u, v):
    graph[u][v] = 1
    graph[v][u] = 1

def is_safe(node, color, graph, c, V):
    for i in range(V):
        if graph[node][i] == 1 and color[i] == c:
            return False
    return True

def solve(i, graph, m, V, color):
    if i == V:
        return True

    for c in range(1, m + 1):
        if is_safe(i, color, graph, c, V):
            color[i] = c
            if solve(i + 1, graph, m, V, color):
                return True
            color[i] = 0  # backtrack

    return False

def graph_coloring(graph, m, V):
    color = [0] * V
    if solve(0, graph, m, V, color):
        print("Solution exists.")
        print("Coloring of vertices:", color)
    else:
        print("No solution exists.")

# Main Execution
V = 5  # Number of vertices
m = 3  # Number of colors

# Initialize adjacency matrix
graph = [[0 for _ in range(V)] for _ in range(V)]

# Add edges
add_edge(graph, 0, 1)
add_edge(graph, 0, 2)
add_edge(graph, 0, 3)
add_edge(graph, 2, 4)
add_edge(graph, 3, 4)

# Solve the problem
graph_coloring(graph, m, V)


# Output
# Solution exists.
# Coloring of vertices: [1, 2, 2, 2, 1]