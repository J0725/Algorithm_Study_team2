import java.util.*;

public class Problem_1197 {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;//시작 정점, 끝 정점, 간선의 가중치
        public Edge(int from, int to, int weight) { //생성자 선언
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 가중치 오름차순 정렬
            //this는 지금 이 함수를 호출한 Edge 객체, o는 비교할 다른 Edge 객체
        }
    }

    static int[] parent;

    // Find 함수 (대표 노드 찾기)
    static int find(int x) {
        if (parent[x] != x)//아직 루트가 아님
            parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }

    // Union 함수 (두 집합 연결)
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
            parent[rootB] = rootA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 수
        int E = sc.nextInt(); // 간선 수

        List<Edge> edges = new ArrayList<>();//간선들을 저장할 리스트
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(a, b, w));
        }

        // 간선 가중치 기준 정렬
        Collections.sort(edges);

        // 대표 배열 초기화
        parent = new int[V + 1]; //각 정점의 부모를 자기 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int total = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {//사이클 유무 확인
                union(edge.from, edge.to);
                total += edge.weight;
            }
        }

        System.out.println(total);
    }
}
