//문제 설명
// 연결 요소 개수 -Undirected Graph
// Union-Find


import java.util.HashSet;
import java.util.Scanner;

public class Problem_11724{
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // node 개수
        int m = sc.nextInt();  // edge 개수

        //부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;  // 자기 자신을 부모로 초기화

        //edge 정보 입력받기
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);  // 두 노드를 같은 집합으로 합친다.
        }

        //연결 요소 개수 찾기
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(find(i));  // 각 노드의 대표자를 집합에 넣는다.

        System.out.println(set.size());  // 집합의 크기가 연결 요소의 개수

        sc.close();
    }

    //부모 노드 찾기
    static int find(int x) {
        if (x == parent[x]) return x;  // 자기 자신이 부모이면 리턴
        return parent[x] = find(parent[x]);  // 부모를 찾아가면서 경로 압축
    }

    //두 집합 합치기
    static void union(int x, int y) {
        int rootX = find(x); //root x = 노드 x의 대표자
        int rootY = find(y);
        if (rootX != rootY) parent[rootY] = rootX;  // 두 집합을 하나로 합치기
    }
}