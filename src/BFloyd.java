import java.util.*;

public class BFloyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();

        floydWarshall(graph, n, src, dest);
    }

    public static void floydWarshall(int[][] graph, int n, int src, int dest) {
        int[][] dist = new int[n][n];
        int[][] pred = new int[n][n];

        // Initialize distance and predecessor matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j];
                } else {
                    dist[i][j] = 99; // Use 99 as infinity
                }
                if (graph[i][j] != 99 && i != j) {
                    pred[i][j] = i;
                } else {
                    pred[i][j] = -1;
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Floyd's shortest path algorithm:");
        System.out.println("The shortest distance from vertex " + src + " to " + dest + " is " + dist[src][dest]);
        System.out.print("The shotest path is ");
        printPath(pred, src, dest);
    }

    private static void printPath(int[][] pred, int src, int dest) {
        if (src == dest) {
            System.out.print(src);
            return;
        }
        if (pred[src][dest] == -1) {
            System.out.print("No path");
            return;
        }
        List<Integer> path = new ArrayList<>();
        int step = dest;
        while (step != src) {
            path.add(step);
            step = pred[src][step];
        }
        path.add(src);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }
}