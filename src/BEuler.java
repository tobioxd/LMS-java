import java.util.*;

public class BEuler {
    private static int[][] graph;
    private static int n;
    private static List<Integer> cycle = new ArrayList<>();
    private static char[] vertices;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        graph = new int[n][n];
        vertices = new char[n];
        
        for (int i = 0; i < n; i++) {
            vertices[i] = (char) ('A' + i);
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        int start = scanner.nextInt();
        scanner.close();

        findEulerCycle(start);

        System.out.println("Euler's cycle:");
        for (int i = cycle.size() - 1 ; i >= 0 ; i--) {
            System.out.print(vertices[cycle.get(i)] + " -> ");
        }
    }

    private static void findEulerCycle(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        List<Integer> currentPath = new ArrayList<>();

        while (!stack.isEmpty()) {
            int v = stack.peek();
            boolean hasUnvisitedEdge = false;

            for (int u = 0; u < n; u++) {
                if (graph[v][u] > 0) {
                    stack.push(u);
                    graph[v][u]--;
                    graph[u][v]--;
                    hasUnvisitedEdge = true;
                    break;
                }
            }

            if (!hasUnvisitedEdge) {
                currentPath.add(stack.pop());
            }
        }

        // Reverse the path to get the correct order
        Collections.reverse(currentPath);
        cycle = currentPath;
    }
}