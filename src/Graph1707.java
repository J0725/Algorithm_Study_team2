//Graph 1707
//이분 그래프(Bipartite Graph): 그래프의 정점을 두 그룹으로 나눠서,
//서로 인접한 정점끼리는 같은 그룹에 속하지 않도록 나눌 수 있는 그래프.
import java.util.*;

public class Graph1707 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] color; // 0: 미방문, 1: 빨강, -1: 파랑

    //BFS방식
    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 시작 노드 색 1로 지정

        while (!queue.isEmpty()) {
            int now = queue.poll(); //queue에서 하나 꺼냄
            for (int next : graph.get(now)) { //now 정점과 **인접한 모든 node(next)**에 대해 반복
                //graph.get(now): now번 node와 연결된 노드 리스트
                if (color[next] == 0) { //next node 를 아직 방문하지 않았다면
                    color[next] = -color[now]; //현재 node과 다른 색(-1을 곱해서)을 칠함
                    queue.add(next); //그리고 next를 큐에 넣어 다음에 탐색
                } else if (color[next] == color[now]) {
                    // 인접 노드가 같은 색이면 이분 그래프 아님
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt(); // 테스트 케이스 수

        while (K-- > 0) { //현재 값 사용 후 1 줄임
            int V = scanner.nextInt(); // node 수
            int E = scanner.nextInt(); // edge 수

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            // edge 입력
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u); // 무방향 그래프
            }

            color = new int[V + 1]; //각 node 에 어떤 색이 칠해졌는지 저장하는 배열
            boolean isBipartite = true;

            // 모든 node 에 대해 확인 (연결 요소 고려)
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}
