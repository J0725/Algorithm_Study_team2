import java.util.*;

public class snd_1260 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int n, m, v;

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        graph[start].sort(Comparator.naturalOrder()); // 오름차순 정렬
        for (int node : graph[start]) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int start) {
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        System.out.print(start + " ");
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    System.out.print(neighbor + " ");
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수
        v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int j = 0; j < m; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(v);
        System.out.print("\n");
        bfs(v);

        sc.close();
    }

}
