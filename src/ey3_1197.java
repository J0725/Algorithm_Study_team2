import java.util.*;

public class ey3_1197 {
    static class Edge { // Edge를 저장할 클래스 정의
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;     // edge의 시작 정점
            this.to = to;         // edge의 도착 정점
            this.weight = weight; // edge의 가중치
        }
    }

    static int[] parent; //Union-Find를 위한 부모 배열 선언

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        Edge[] edges = new Edge[E]; //// edge 정보를 담을 배열
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); //node A
            int B = sc.nextInt(); //node B
            int C = sc.nextInt(); //가중치
            edges[i] = new Edge(A, B, C);
        }

        // 정렬
        Arrays.sort(edges, (e1, e2) -> e1.weight - e2.weight);
        //Arrays.sort(배열이름, 배열기준): 자바에서 배열을 정렬할 때 사용하는 메서드

        parent = new int[V + 1]; // node 번호가 1부터 시작하므로 크기 V+1
        for (int i = 1; i <= V; i++) {
            parent[i] = i; //// 각 node의 부모를 자기 자신으로 초기화
        }

        long result = 0; //총 가중치
        int count = 0; //선택된 edge의 수

        for (Edge e : edges) {
            if (union(e.from, e.to)) { //union()이 true를 반환하면
                result += e.weight; // MST에 포함되므로 가중치 더함
                count++; //edge 수 증가
                if (count == V - 1) break;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] != x) //대표 부모 찾기
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false; //이미 같은 집합이면 사이클 발생 → 연결 X
        parent[rootB] = rootA; //// 루트가 다르면 → 두 집합을 하나로 합침
        return true; // edge 연결
    }
}
