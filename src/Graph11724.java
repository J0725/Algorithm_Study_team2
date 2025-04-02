//연결 요소의 개수 구하기
//연결 요소의 개수 = 그래프의 개수

import java.util.ArrayList;
import java.util.Scanner;

public class Graph11724 {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N+1];

        //ArrayList 배열 초기화
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        //ArrayList 배열 채우기
        for (int i = 0; i < M; i++) {
           int u = sc.nextInt();
           int v = sc.nextInt();
           graph[u].add(v);
           graph[v].add(u); //무방향이므로 양쪽으로 add
        }

        visited = new boolean[N+1];
        int count = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){ //방문하지 않은 노드에 대해 dfs실행
                dfs(i);
                count++;
            }
        }

        System.out.println(count);



    }

    //recursion으로 dfs 구현
    static void dfs(int node) {
        visited[node] = true; //현재 노드를 방문처리

        for(int next : graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}