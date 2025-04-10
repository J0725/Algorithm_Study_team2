import java.util.Scanner;

public class snd_1012 {
    static int[][] map;
    static boolean[][] visited;
    static int t, m, n, k;

    static int[] dx = {1, -1, 0, 0}; // 왼오 탐색
    static int[] dy = {0, 0, 1, -1}; // 위아래 탐색

    // 탐색을 1회 진행했을 때 방문되는 배추들이 하나의 그룹 = 지렁이 하나
    public static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 처리 먼저

        for (int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) { // 범위 벗어나지 않을 때
                if (!visited[nextX][nextY] && map[nextX][nextY] == 1) { // 방문하지 않은 배추인 경우
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt(); // test case 개수

        for (int j = 0; j < t; j++) {
            m = sc.nextInt(); // 밭 가로 길이
            n = sc.nextInt(); // 밭 세로 길이
            k = sc.nextInt(); // 배추 개수

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i<k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[b][a] = 1; // 배추 심은 곳
            }

            int count = 0;
            for (int i=0; i<n; i++) {
                for (int l = 0; l < m; l++) {
                    if (!visited[i][l] && map[i][l] == 1) { // 방문하지 않은 배추가 있으면
                        dfs(i, l); // dfs 탐색 진행
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}
