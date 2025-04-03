//Graph 11724
import java.util.*;

public class Graph11724{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //바깥쪽 ArrayList는 node 번호용, 안쪽 ArrayList는 각 node의 연결 리스트용.
    //main()이 static이기 때문에 그 안에서 직접 접근하려면 이것도 static으로 해야함
    static boolean[] visited; // node 방문 여부 체크용

    //DFS방식
    static void dfs(int node) {
        visited[node] = true; // 1. 방문 표시
        for (int next : graph.get(node)) { // 2. 현재 노드와 연결된 모든 노드(next)에 대해
            if (!visited[next]) { // 3. 아직 방문 안 했으면
                dfs(next); // 4. 그 노드로 DFS 재귀 호출
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); //node 갯수
        int m = scanner.nextInt(); //edge 갯수

        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }//각 정점이 연결된 정점들을 담을 빈 ArrayList 를
        // graph 라는 큰 리스트에 n개 추가하는 과정.

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            //두 정점 u와 v 사이에 간선을 추가
            graph.get(u).add(v); //u번 정점에 연결된 정점 리스트에 v를 추가
            graph.get(v).add(u); //v번 정점에도 u를 추가 -> 양방향 연결(무방향 그래프)
            //get(): 꺼내기. graph 라는 리스트에서 u번 정점에 해당하는 리스트를 꺼냄
            //add(): 리스트에 값 넣기. 그 리스트에 v라는 값을 추가함
        }

        //그래프가 전부 연결되어 있다는 보장이 없음
        //하나의 DFS로는 전체를 못봄
        //->모든 node 검사하면서 아직 방문 안 한 node가 있으면 다시 한 번 DFS 호출

        visited = new boolean[n + 1]; //방문 배열 초기화

        int count = 0;
        for (int i = 1; i <= n; i++){
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}