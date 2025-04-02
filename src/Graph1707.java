//이분 그래프 판별

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph1707 {
    static ArrayList<Integer>[] graph;
    static int[] group; //미방문 = 0, 그룹A = 1, 그룹 B = 2로 설정
    static boolean isBipartite;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); //testcase 개수
        ArrayList<String> result = new ArrayList<>(); //결과 담을 ArrayList

        while(K --> 0){ //각 testcase별로 간선 입력 받아 bfs 실행
            int V = sc.nextInt();
            int E = sc.nextInt();

            graph = new ArrayList[V+1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 1; i <= E; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            group = new int[V+1];
            isBipartite = true;

            for(int i=1; i <= V; i++){
                if(group[i] == 0){ //아직 방문 안한 정점에 대해 bfs 수행
                    bfs(i);
                }
            }

            result.add(isBipartite ? "YES" : "NO");
        }
        for (String res : result) {
            System.out.println(res);
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        group[start] = 1; //시작 노드를 그룹A로 지정

        while(!q.isEmpty()){
            int current = q.poll();

            for(int neighbor : graph[current]){
                if(group[neighbor] == 0){
                    group[neighbor] = 3 - group[current]; // 현재 노드 그룹이 1이면 2, 2면 1로 설정 -> 인접한 노드끼리 다르게
                    q.add(neighbor);
                }
                else if(group[neighbor] == group[current]){
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
