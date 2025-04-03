//문제 설명
// 이분 그래프 찾기
// BFS(너비우선탐색)
//각 노드를 집합 0, 집합 1로 번갈아 가면서 정리(방문하지 않으면 -1)

import java.util.*;

public class Problem_1707 {
    static ArrayList<Integer>[] graph; //각 노드마다 연결된 노드들을 리스트로 저장
    static int[] check; // 노드의 색을 저장할 배열 (0 또는 1)
    static boolean IsEven; // 이분 그래프인지 확인하는 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 테스트 케이스 개수 입력 받기

        for (int t = 0; t < K; t++) {
            int V = sc.nextInt(); // node 개수 입력 받기
            int E = sc.nextInt(); // edge 개수 입력 받기

            //그래프 초기화(저장공간)
            graph = new ArrayList[V + 1]; //배열 크기 1~V
            check = new int[V + 1];
            IsEven = true;

            //그래프 초기화(노드와 연결정보 저장)
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>(); // 각 노드가 연결된 노드를 저장할 리스트
                check[i] = -1; // 모든 노드를 방문하지 않은 상태로 초기화 (-1)
            }

            //노드 연결
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            //그래프 탐색(BFS)
            for (int i = 1; i <= V; i++) {
                if (check[i] == -1) { // 방문하지 않은 노드만 탐색
                    if (!bfs(i)) { // 이분 그래프가 아닌 경우
                        IsEven = false;
                        break;
                    }
                }
            }

            if (IsEven) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = 0; // 시작 노드를 집합 0으로 색칠

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) { // 연결된 모든 노드 확인
                if (check[neighbor] == -1) { // 아직 방문하지 않은 노드라면
                    check[neighbor] = 1 - check[node]; // 다른 집합으로 색칠 (0 -> 1, 1 -> 0)
                    queue.add(neighbor); //발문한 노드 다시 큐에 넣기
                } else if (check[neighbor] == check[node]) { // 같은 색으로 칠해져 있다면 이분 그래프 아님
                    return false;
                }
            }
        }
        return true; // 문제없이 탐색을 완료하면 이분 그래프임
    }
}