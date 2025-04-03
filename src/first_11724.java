import java.util.*;

public class first_11724 {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 정점 개수
        int m = sc.nextInt();  // 간선 개수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 연결 요소 개수 구하기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {  // 새로운 연결 요소 발견
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
