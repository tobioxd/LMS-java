import java.util.*;

public class BDijkstra {
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

        dijkstra(graph, n, src, dest);
    }

    public static void dijkstra(int[][] graph, int n, int src, int dest) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] pred = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(pred, -1);
        dist[src] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(node -> dist[node]));
        pq.add(src);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 99 && !visited[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pred[v] = u;
                    pq.add(v);
                }
            }
        }
        System.out.println();
        System.out.println("Dijkstra's shortest path algorithm:");
        System.out.println("The shortest distance from vertex " + src + " to " + dest + " is " + dist[dest]);
        System.out.print("The shotest path is ");
        printPath(pred, dest);
    }

    private static void printPath(int[] pred, int dest) {
        if (pred[dest] == -1) {
            System.out.print(dest);
            return;
        }
        printPath(pred, pred[dest]);
        System.out.print(" -> " + dest);
    }
}