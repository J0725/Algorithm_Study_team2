import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1197 {
    static int V, E;
    static int parent[]; //유니온 파인드용 배열
    static Edge edges[]; //간선 배열
    static int weight;

    static class Edge{
        int u, v, c;
        Edge(int u, int v, int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = parent[x];
        y = parent[y];

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new Edge[E];

        for(int i = 0; i < V+1; i++) parent[i] = i;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, c);
        }

        //weight 오름차순 정렬
        Arrays.sort(edges, (o1,o2) -> (o1.c - o2.c));

        //Kruskal 알고리즘
        for(int i = 0; i < E; i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            weight += now.c;
            union(now.u, now.v);
        }

        System.out.println(weight);
    }
}
