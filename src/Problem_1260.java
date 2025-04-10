import java.util.*;

public class Problem_1260 {
    static boolean[] visited;         // 방문 여부 확인 배열
    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 표현

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 노드 수 N, 엣지 수 M, 시작 노드 V 입력
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        // 그래프 배열 초기화 (1번부터 N번까지 사용하므로 N+1)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 엣지 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a); // 양방향 그래프
        }

        // 각 노드에 연결된 리스트를 정렬 (번호 작은 순 방문을 위해)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1]; // 방문 배열 초기화
        dfs(V);
        System.out.println();

        // BFS 수행
        visited = new boolean[N + 1]; // 방문 배열 다시 초기화
        bfs(V);
     scanner.close();   
    }

    // DFS 함수 (재귀 방식)
    public static void dfs(int v) {
        visited[v] = true;         // 현재 노드 방문 표시
        System.out.print(v + " "); // 출력

        // 연결된 노드들을 하나씩 방문
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS 함수 (큐 사용)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start); //노드를 큐에 넣고 방문 표시

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
