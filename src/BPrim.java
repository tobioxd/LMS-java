import java.util.*;

public class BPrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int startVertex = sc.nextInt() - 1;         
    int[][] graph = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST(graph, V, startVertex);
    }

    public static void primMST(int[][] graph, int V, int startVertex) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[startVertex] = 0;
        parent[startVertex] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    public static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void printMST(int[] parent, int[][] graph, int V) {
        int totalWeight = 0;
        List<String> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (parent[i] != -1) {
                totalWeight += graph[i][parent[i]];
                edges.add((parent[i] + 1) + "   " + (i + 1));
            }
        }

        System.out.println("dH = " + totalWeight);
        //for (String edge : edges) {
           // System.out.println(edge);
        //}
    }
}