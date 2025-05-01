import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class fif_7568 {
    static int[] w;
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer> res = new ArrayList<>();
    static int[][] memo;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        w = new int[n+1];
        tree = new ArrayList[n+1];
        memo = new int[n+1][2];
        visit = new boolean[n+1];

        String st = sc.nextLine();
        String[] stArr = st.split(" ");
        for(int i=1; i<=n; i++){
            w[i] = Integer.parseInt(stArr[i-1]);

            tree[i] = new ArrayList();
        }

        for(int i=1; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        visit = new boolean[n+1];

        if(memo[1][0] > memo[1][1]){
            System.out.println(memo[1][0]);
            trace(1, 0);
        } else{
            System.out.println(memo[1][1]);
            trace(1, 1);
        }

        Collections.sort(res);

        for(int num : res){
            System.out.print(num + " ");
        }

    }

    public static void dfs(int cur){
        int size = tree[cur].size(); // 인접 노드 개수

        memo[cur][0] = 0;      // cur을 선택하지 않음
        memo[cur][1] = w[cur]; // cur을 선택 -> 가중치 반영
        visit[cur] = true;

        for(int i=0; i<size; i++){
            int next = tree[cur].get(i);
            if(!visit[next]){
                dfs(next);

                memo[cur][0] += Math.max(memo[next][0], memo[next][1]); // 자식을 선택할 수도, 안 할 수도
                memo[cur][1] += memo[next][0]; // cur이 선택되었으므로 자식을 선택하면 안됨
            }
        }
    }

    public static void trace(int cur, int inc){
        visit[cur] = true;

        if(inc == 1){ // cur 노드를 포함시키는 경우
            res.add(cur); // cur을 결과값에 포함 시킴
            for(int next : tree[cur]){
                if(!visit[next])
                    trace(next, 0); // 자식은 포함시키지 않음
            }
        } else{ // cur 노드를 포함시키지 않는 경우
            for(int next : tree[cur]){
                if(!visit[next]){
                    if(memo[next][1] > memo[next][0]){
                        trace(next, 1); // 자식이 포함되는 것이 이득
                    } else trace(next, 0);
                }
            }
        }
    }
}