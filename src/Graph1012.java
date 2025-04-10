import java.util.*;

public class Graph1012 {
    static int[][] map;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); //test 케이스 수

        while (T-- > 0) {
            M = scanner.nextInt(); // 가로
            N = scanner.nextInt(); // 세로
            int K = scanner.nextInt(); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();

                map[Y][X] = 1;
            }

            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!visited[y][x]) {
                        if (map[y][x] == 1) {
                            dfs(x, y);
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[y][x] = true; // 방문 표시

        for (int dir = 0; dir < 4; dir++) { //상하좌우 4방향으로 탐색
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //dx, dy를 이용해 새로운 좌표(nx, ny) 계산

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) { //로운 좌표가 배추밭 범위 안에 있는지 확인
                if (map[ny][nx] == 1 && !visited[ny][nx]) { //해당 위치에 배추가 있는지, 아직 방문하지 않은 위치인지 확인
                    dfs(nx, ny); //다음 위치로 DFS 재귀 호출
                }
            }
        }
    }
}
