import java.util.*;

public class thrd_1922 {
    static List<Edge> graph;
    static int parent[];
    static int n, m;

    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }
    }

    public static int find(int x) { // x가 속한 집합의 루트 노드를 찾는 함수
        if (x == parent[x]) { // 간선이 연결되지 않은 경우 자신을 가리킴
            return x;
        }
        return parent[x] = find(parent[x]); // 루트 노드를 찾아서 갱신해줌
    }

    public static void union(int x, int y) { // x에서 y로 연결되는 간선 선택
        x = find(x); // x의 루트를 찾음
        y = find(y); // y의 루트를 찾음

        if (x!=y) { // 둘이 전혀 다른 집합에 속해있다면
            parent[y] = x; // x -> y로 연결하고 y의 루트를 갱신
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수

        graph = new ArrayList<>();
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.add(new Edge(a, b, c));
        }

        Collections.sort(graph,new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int total = 0;
        for (int i=0; i<graph.size(); i++) {
            Edge edge = graph.get(i);

            if(find(edge.start) != find(edge.end)){ // 부모가 같지 않은 경우 (사이클 없음)
                total += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(total);

    }
}
