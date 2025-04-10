import java.util.*;

public class Graph1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //바깥쪽 ArrayList는 node 번호용, 안쪽 ArrayList는 각 node의 연결 리스트용.
    //main()이 static이기 때문에 그 안에서 직접 접근하려면 이것도 static으로 해야함
    static boolean[] visited; // node 방문 여부 체크용

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); //node 갯수
        int M = scanner.nextInt(); //edge 갯수
        int V = scanner.nextInt(); //시작할 node 번호

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }//각 정점이 연결된 정점들을 담을 빈 ArrayList 를
        // graph 라는 큰 리스트에 n개 추가하는 과정.

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            //두 정점 u와 v 사이에 간선을 추가
            graph.get(u).add(v); //u번 정점에 연결된 정점 리스트에 v를 추가
            graph.get(v).add(u); //v번 정점에도 u를 추가 -> 양방향 연결(무방향 그래프)
            //get(): 꺼내기. graph 라는 리스트에서 u번 정점에 해당하는 리스트를 꺼냄
            //add(): 리스트에 값 넣기. 그 리스트에 v라는 값을 추가함
        }

        for (int i = 1; i <= N; i++) { //각 정점의 인접리스트 정렬
            Collections.sort(graph.get(i));
        } // Collections.sort() : 리스트를 오름차순 정렬 (작은 번호부터 탐색하게 함)

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int v) {
        visited[v] = true; // 1. 방문 표시
        System.out.print(v + " ");
        for (int next : graph.get(v)) { // 2. 현재 노드와 연결된 모든 노드(next)에 대해
            if (!visited[next]) { // 3. 아직 방문 안 했으면
                dfs(next); // 4. 그 노드로 DFS 재귀 호출
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll(); //queue에서 하나 꺼냄
            System.out.print(now + " ");
            for (int next : graph.get(now)) { //now 정점과 **인접한 모든 node(next)**에 대해 반복
                //graph.get(now): now번 node와 연결된 노드 리스트
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
