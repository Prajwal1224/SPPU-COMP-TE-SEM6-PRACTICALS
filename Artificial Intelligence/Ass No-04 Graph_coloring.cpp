#include <iostream>
#include <vector>
using namespace std;

void addEdge(int graph[5][5], int edge1, int edge2) {
    graph[edge1][edge2] = 1;
    graph[edge2][edge1] = 1;
}

bool safeToAssign(int i, int j, int graph[5][5], int v, vector<int> &color) {
    for (int k = 0; k < v; k++) {
        if (graph[i][k] == 1 && color[k] == j) {
            return false; // If adjacent node has the same color, return false
        }
    }
    return true;
}

bool function(int graph[5][5], int m, int v, int i, vector<int> &color) {
    if (i == v) {
        return true; // If all vertices are colored successfully
    }

    for (int j = 0; j < m; j++) {
        if (safeToAssign(i, j, graph, v, color)) {
            color[i] = j; // Assign color
            if (function(graph, m, v, i + 1, color)) return true; // Recurse for the next vertex
            color[i] = -1; // Backtrack if coloring doesn't work
        }
    }
    return false;
}

bool graphColoring(int graph[5][5], int m, int v) {
    vector<int> color(v, -1); // Initialize color array with -1 for all vertices
    int i = 0; // Start with the first vertex
    return function(graph, m, v, i, color);
}

int main() {
    int m = 3;  // Number of colors
    int v = 5;  // Number of vertices
    int graph[5][5] = {0};  // Initialize graph with all zeros (no edges)

    // Adding edges
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 0, 3);
    addEdge(graph, 2, 4);
    addEdge(graph, 3, 4);

    if (graphColoring(graph, m, v)) {
        cout << "Solution exists." << endl;
    } else {
        cout << "No solution exists." << endl;
    }

    return 0;
}

#Output
#Solution exists.
