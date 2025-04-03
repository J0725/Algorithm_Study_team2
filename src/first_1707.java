import java.util.*;

public class first_1707 {
    static List<Integer>[] graph;
    static int[] colors; // 색상 배열: 0 = 미방문, 1 = 빨강, -1 = 파랑

    public static boolean isBipartite(int v) {
        Queue<Integer> queue = new LinkedList<>();

        for (int start = 1; start <= v; start++) { // 모든 정점 탐색
            if (colors[start] != 0) continue; // 이미 방문한 경우 스킵

            queue.add(start);
            colors[start] = 1; // 첫 노드를 빨간색으로 색칠

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) { // 방문하지 않은 경우
                        colors[neighbor] = -colors[node]; // 반대 색상 칠하기
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        return false; // 같은 색상이면 이분 그래프 아님
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < k; i++) {
            int v = sc.nextInt(); // 정점 개수
            int e = sc.nextInt(); // 간선 개수

            graph = new ArrayList[v + 1];
            colors = new int[v + 1]; // 방문하지 않은 노드는 0

            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }

            // 간선 입력
            for (int j = 0; j < e; j++) {
                int u = sc.nextInt();
                int f = sc.nextInt();
                graph[u].add(f);
                graph[f].add(u);
            }

            boolean isBipartite = isBipartite(v);
            System.out.println(isBipartite ? "YES" : "NO");
        }

        sc.close();
    }
}
