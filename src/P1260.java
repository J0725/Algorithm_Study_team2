import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    static int N,M,V;
    static int[][] graph; //인접 행렬
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void dfs(int node) {
        visited[node] = true;

        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) { //i node와 연결되어 있는데, 아직 방문하지 않은 노드에 대하여 dfs 실행
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        q.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[t][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());

        graph = new int[N+1][N+1]; //정점 초기화(문제에서 정점은 '1'부터 시작한다고 되어있으므로 N+1

        //간선 정보를 입력 받아 그래프를 생성
        for(int j = 0; j < M; j++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);

        System.out.println();

        visited = new boolean[N+1];
        bfs(V);

    }
}
