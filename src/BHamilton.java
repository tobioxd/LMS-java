import java.util.*;

public class BHamilton {
    private static int[][] graph;
    private static int n;
    private static List<List<Integer>> allCycles = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int startVertex = scanner.nextInt() - 1; // Adjusting for 0-based index
        graph = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        List<Integer> path = new ArrayList<>();
        path.add(startVertex);
        visited[startVertex] = true;

        findHamiltonianCycles(startVertex, startVertex, path);

        for (List<Integer> cycle : allCycles) {
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print((cycle.get(i) + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void findHamiltonianCycles(int start, int current, List<Integer> path) {
        if (path.size() == n) {
            if (graph[current][start] == 1) {
                path.add(start);
                allCycles.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                path.add(i);
                findHamiltonianCycles(start, i, path);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}