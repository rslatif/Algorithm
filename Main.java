import java.util.Stack;

public class Main {
    static final int maxNodes = 6;
    static boolean[] visited = new boolean[maxNodes];
    static int[][] graph = {
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1, 0}
    };

    static void dfs(int numNodes, int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;

        System.out.println("Spanning Tree Edges:");
        while (!stack.empty()) {
            int currentNode = stack.pop();

            for (int neighbor = 0; neighbor < numNodes; ++neighbor) {
                if (graph[currentNode][neighbor] == 1 && !visited[neighbor]) {
                    System.out.println(currentNode + " - " + neighbor); // Print edge
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < maxNodes; i++) {
            visited[i] = false;
        }

        int startNode;
        System.out.print("Enter the starting node (index from 0 to " + (maxNodes - 1) + "): ");
        startNode = Integer.parseInt(System.console().readLine());

        if (startNode < 0 || startNode >= maxNodes) {
            System.out.println("Invalid starting node!");
            return;
        }
        dfs(maxNodes, startNode);
    }
}
